package fr.imie.edycem.util;


import fr.imie.edycem.exception.EdycemResourceNotFoundException;

public class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    // API
    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param expression
     *            has value true if found, otherwise false
     * @throws EdycemResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new EdycemResourceNotFoundException();
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     *
     * @param resource
     *            has value true if found, otherwise false
     * @throws EdycemResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new EdycemResourceNotFoundException();
        }

        return resource;
    }
}