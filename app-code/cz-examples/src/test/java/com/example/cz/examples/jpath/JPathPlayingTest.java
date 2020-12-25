/*----------------------------------------------------------------------------*/
/* Source File:   JPATHPLAYINGTEST.JAVA                                       */
/* Copyright (c), 2020 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Dec.24/2020  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.example.cz.examples.jpath;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

/**
 * <p>Unit Tests to exercise JPath Syntax learning.</p>
 * <p>This Unit Test file does not have an associated SRC file. It is in Unit
 * tests to have a chance to understand how JPath works.</p>
 * <p>It uses the Java Lib JsonPath</p>
 * <p><br/><br/><b>Reference links</b>
 * <u>
 * <li><a href="https://support.smartbear.com/alertsite/docs/monitors/api/endpoint/jsonpath.html">JSONPath Syntax</a></li>
 * <li><a href="https://www.toolsqa.com/rest-assured/expressions-in-jsonpath/">Expressions in JSONPath</a></li>
 * <li><a href="https://stackoverflow.com/questions/28954720/jsonpath-expression-to-filter-using-regex">JsonPath expression to filter using regex</a></li>
 * <li><a href="https://github.com/json-path/JsonPath">JsonPath</a></li>
 * <li><a href="https://support.smartbear.com/alertsite/docs/monitors/api/endpoint/jsonpath.html">jSONPath Syntax</a></li>
 * </u></p>
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Dec.24/2020
 * @since 15 (JDK), Dec.24/2020
 */
class JPathPlayingTest {

    private static final String JPATH_QUERY_STORE = "$.store.*";
    private static final String JPATH_QUERY_STORE_BOOKS = "$.store.book[*]";
    private static final String JPATH_QUERY_BOOK_TITLES = "$..book[*].title";
    private static final String JPATH_QUERY_BOOK_WITH_ISBN = "$..book[?(@.isbn)]";
    private static final String JPATH_QUERY_BOOK_WITHOUT_ISBN = "$..book[?(!@.isbn)]";
    private static final String JPATH_QUERY_BOOK_PRICE_LESS_THAN_TEN = "$..book[?(@.price < 10)]";
    private static final String JPATH_QUERY_BOOK_PRICE_IS_EXPENSIVE = "$..book[?(@.price > $.expensive)]";
    private static final String JPATH_QUERY_BOOK_AUTHOR_ENDS_WITH_TOLKIEN_INSENSITIVE = "$..book[?(@.author =~ /.*Tolkien/i)]";
    private static final String JPATH_QUERY_BOOK_CATEGORY_FICTION_CATEGORY_REFERENCE = "$..book[?(@.category == 'fiction' || @.category == 'reference')]";
    private static final String JPATH_QUERY_BOOK_TITLE_SWORD_CASE_INSENSITIVE = "$..book[?(@.title =~ /^.*Sword.*$/i)].title";
    private static final String JPATH_QUERY_ROOT_STRUCTURE = "$..*";

    private static final String ASSERTION_ROOT_STRUCTURE = "All members of the JSON structure beneath the root (child objects, individual property values, array items), combined into an array.";
    private static final String ASSERTION_BOOK_STORE_ITEMS_FAILURE = "Book Store Items Failure \uD83D\uDE31";
    private static final String ASSERTION_BOOKS_IN_STORE = "Books in store";
    private static final String ASSERTION_RETRIEVE_BOOK_TITLES = "Retrieve Book Titles";
    private static final String ASSERTION_BOOKS_WITH_ISBN = "Books with ISBN";
    private static final String ASSERTION_BOOKS_WITHOUT_ISBN = "Books without ISBN";
    private static final String ASSERTION_BOOK_TITLE_SWORD_CASE_INSENSITIVE = "Titles with the Word 'Sword'";
    private static final String ASSERTION_BOOK_PRICE_LESS_THAN_TEN = "Books cheaper than 10";
    private static final String ASSERTION_BOOK_PRICE_IS_EXPENSIVE = "Book price is Expensive";
    private static final String ASSERTION_BOOKS_WHOSE_AUTHOR_NAME_ENDS_WITH_TOLKIEN_CASE_INSENSITVE = "Books whose author name ends with Tolkien (case insensitve)";
    private static final String ASSERTION_BOOKS_WITH_FICTION_AND_REFERENCE_CATEGORY = "Books with Fiction and Reference Category";

    private static final String BOOK_TITLE_SAYINGS_OF_THE_CENTURY = "Sayings of the Century";
    private static final String BOOK_TITLE_MOBY_DICK = "Moby Dick";
    private static final String BOOK_TITLE_SWORD_OF_HONOUR = "Sword of Honour";
    private static final String BOOK_TITLE_LOOKING_WITH_THE_SWORD_OF_HONOUR = "Looking with the Sword of Honour";
    private static final String BOOK_TITLE_THE_LORD_OF_THE_RINGS = "The Lord of the Rings";

    private static DocumentContext jsonContext;
    private static final String bookStore =
        """
                {
                  "store": {
                    "book": [
                      {
                        "category": "reference",
                        "author": "Nigel Rees",
                        "title": "Sayings of the Century",
                        "price": 8.95
                      },
                      {
                        "category": "fiction",
                        "author": "Herman Melville",
                        "title": "Moby Dick",
                        "isbn": "0-553-21311-3",
                        "price": 8.99
                      },
                      {
                        "category": "fiction",
                        "author": "Evelyn Waugh",
                        "title": "Sword of Honour",
                        "price": 12.99
                      },
                      {
                        "category": "reference",
                        "author": "Jhon Wright",
                        "title": "Looking with the Sword of Honour",
                        "price": 22.99
                      },
                      {
                        "category": "fiction",
                        "author": "J.R.R. Tolkien",
                        "title": "The Lord of the Rings",
                        "isbn": "0-395-19395-8",
                        "price": 22.99
                      }
                    ],
                    "bicycle": {
                      "color": "red",
                      "price": 19.95
                    }
                  },
                  "expensive": 10
                }
            """;

    @BeforeAll
    public static void init() {
        jsonContext = JsonPath.parse(bookStore);
    }

    @Test
    @DisplayName("Check that store has items")
    void givenBookStoreThenItHasItems() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_STORE))
            .as(ASSERTION_BOOK_STORE_ITEMS_FAILURE)
            .hasSize(2);
    }

    @Test
    @DisplayName("Check that there are books in store")
    void givenBookStoreExtractBooks() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_STORE_BOOKS))
            .as(ASSERTION_BOOKS_IN_STORE)
            .hasSize(5);
    }

    @Test
    @DisplayName("Chwck that we get all books titles in Store")
    void givenBookStoreRetrieveBookTitles() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_TITLES))
            .as(ASSERTION_RETRIEVE_BOOK_TITLES)
            .hasSize(5)
            .contains(
                BOOK_TITLE_SAYINGS_OF_THE_CENTURY,
                BOOK_TITLE_MOBY_DICK,
                BOOK_TITLE_SWORD_OF_HONOUR,
                BOOK_TITLE_LOOKING_WITH_THE_SWORD_OF_HONOUR,
                BOOK_TITLE_THE_LORD_OF_THE_RINGS);
    }

    @Test
    @DisplayName("Check that we can get books with ISBN")
    void givenBookStoreItContainsISBNBooksSet() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_WITH_ISBN))
            .as(ASSERTION_BOOKS_WITH_ISBN)
            .hasSize(2);
    }

    @Test
    @DisplayName("Check that we can get books without ISBN")
    void givenBookStoreGetBooksWithNoISBN() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_WITHOUT_ISBN))
            .as(ASSERTION_BOOKS_WITHOUT_ISBN)
            .hasSize(3);
    }

    @Test
    @DisplayName("Check Store has books cheaper than 10")
    void givenBookStoreGetBooksWithPriceCheaperThanTen() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_PRICE_LESS_THAN_TEN))
            .as(ASSERTION_BOOK_PRICE_LESS_THAN_TEN)
            .hasSize(2);
    }

    @Test
    @DisplayName("Check Store with most expensive books")
    void givenBookStoreGetAllExpensiveBooks() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_PRICE_IS_EXPENSIVE))
            .as(ASSERTION_BOOK_PRICE_IS_EXPENSIVE)
            .hasSize(3);
    }

    @Test
    @DisplayName("Check Store has Books whose author name ends with Tolkien (case insensitve)")
    void givenBookStoreGetAllBooksAuthorNameEndsWithTolkienCaseInsensitive() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_AUTHOR_ENDS_WITH_TOLKIEN_INSENSITIVE))
            .as(ASSERTION_BOOKS_WHOSE_AUTHOR_NAME_ENDS_WITH_TOLKIEN_CASE_INSENSITVE)
            .hasSize(1);
    }

    @Test
    @DisplayName("Check Store has Books with Fiction and Reference Category")
    void givenBookStoreGellAllBooksWithFictionAndReferenceCategory() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_CATEGORY_FICTION_CATEGORY_REFERENCE))
            .as(ASSERTION_BOOKS_WITH_FICTION_AND_REFERENCE_CATEGORY)
            .hasSize(5);
    }

    @Test
    @DisplayName("Check All members of the JSON structure beneath the root (child objects, individual property values, array items), combined into an array.")
    void givenBookStoreGetAllItemsBelowRootStructure() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_ROOT_STRUCTURE))
            .as(ASSERTION_ROOT_STRUCTURE)
            .hasSize(33);
    }

    @Test
    @DisplayName("Check Store has Titles with the word 'Sword'")
    void givenBookStoreGetAllBooksWithSwordInTitle() {
        assertThat(jsonContext.<JSONArray>read(JPATH_QUERY_BOOK_TITLE_SWORD_CASE_INSENSITIVE))
            .as(ASSERTION_BOOK_TITLE_SWORD_CASE_INSENSITIVE)
            .hasSize(2);
    }
}
