package by.bsuir.netcracker.persistance.impl;

import by.bsuir.netcracker.persistance.dao.*;


/**
 * Created by Huge Boss on 03.11.2016.
 */
public class Factory {
    private static BookDao bookDao = null;
    private static AuthorDao authorDao = null;
    private static LanguageDao languageDao = null;
    private static Factory instance = null;
    private static OrderDao orderDao = null;
    private static PhoneDao phoneDao = null;
    private static UserDao userDao = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public static AuthorDao getAuthorDao() {
        if (authorDao == null){
            authorDao = new AuthorDatabaseDao();

        }
        return authorDao;
    }

    public static LanguageDao getLanguageDao() {
        if (languageDao == null){
            languageDao = new LanguageDatabaseDao();

        }
        return languageDao;
    }

    public BookDao getBookDao(){
        if (bookDao == null){
            bookDao = new BookDatabaseDao();

        }
        return bookDao;
    }

}
