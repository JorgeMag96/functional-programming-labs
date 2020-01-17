package com.adhoc.java.functional.labs.optional;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalLab {

	// TODO: fix the class Book and Chapter to make this code "null safe"

	@Test
	void refactorToBeSafeTest() {
		Book book = Book.getDummyBook();
		String summary = book.getChapter(10).map(c -> c.getSummary()).orElse("");
	}
}

class Book {
	public String name;
	private List<Chapter> chapters;

	static class Chapter {
		int chapterid;
		String summary;

		Chapter(int id, String summary) {
			this.chapterid = id;
			this.summary = summary;
		}

		public  String getSummary() {
			return Optional.of(this.summary).orElse("");
		}
	}

	public Optional<Chapter> getChapter(int id) {
		Chapter resultChapter = null;
		for (Chapter chapter : chapters) {
			if (chapter.chapterid == id) {
				resultChapter = chapter;
			}
		}
		return Optional.ofNullable(resultChapter);
	}

	public static Book getDummyBook() {
		Book book = new Book();
		book.chapters = List.of(new Chapter(1, "first chapter"), new Chapter(2, "second chapter"),
				new Chapter(3, "third chapter"));
		return book;
	}

}