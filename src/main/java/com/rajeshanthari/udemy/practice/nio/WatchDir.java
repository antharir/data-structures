package com.rajeshanthari.udemy.practice.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class WatchDir {

	WatchService watcher;
	Map<WatchKey, Path> keys;
	boolean trace = false;

	private static final String DIRECTORY_PATH = "C:\\Users\\ranthari\\Downloads\\AL_FILTER\\";

	public static void main(String[] args) throws IOException {
		// register directory and process its events
		Path dir = Paths.get(DIRECTORY_PATH);
		new WatchDir(dir).processEvents();
	}

	public WatchDir(Path path) throws IOException {
		this.watcher = FileSystems.getDefault().newWatchService();
		keys = new HashMap<>();
		// Register recursively
		registerAll(path);
		this.trace = true;
	}

	private void registerAll(Path path) throws IOException {
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

				// Registering each folder/directory
				register(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	private void register(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		if (trace) {
			Path prev = keys.get(key);
			if (prev == null) {
				System.out.format("register: %s\n", dir);
			} else {
				if (!dir.equals(prev)) {
					System.out.format("update: %s -> %s\n", prev, dir);
				}
			}
		}
		keys.put(key, dir);
	}

	public void processEvents() {
		for (;;) {
			WatchKey key;
			try {
				key = watcher.take();
			} catch (Exception e) {
				return;
			}
			Path dir = keys.get(key);
			if (dir == null) {
				System.out.println("Watch Key not registered");
				continue;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				Kind<?> kind = event.kind();
				if (kind == StandardWatchEventKinds.OVERFLOW) {
					System.out.println("Overflowed");
					continue;
				}

				WatchEvent<Path> ev = cast(event);
				Path name = ev.context();
				Path child = dir.resolve(name);
				// print out event
				System.out.format("%s: %s\n", event.kind().name(), child);

				// if directory is created, and watching recursively, then
				// register it and its sub-directories
				if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
					try {
						if (Files.isDirectory(child, LinkOption.NOFOLLOW_LINKS)) {
							registerAll(child);
						}
					} catch (IOException x) {
						// ignore to keep sample readbale
					}
				}
			}

			// reset key and remove from set if directory no longer accessible
			boolean valid = key.reset();
			if (!valid) {
				keys.remove(key);

				// all directories are inaccessible
				if (keys.isEmpty()) {
					break;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	static <T> WatchEvent<T> cast(WatchEvent<?> event) {
		return (WatchEvent<T>) event;
	}

}
