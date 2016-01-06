package com.bitdubai.fermat_cht_plugin.layer.middleware.chat.version_1.database;

        import com.bitdubai.fermat_api.DealsWithPluginIdentity;
        import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabase;
        import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTable;
        import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTableRecord;
        import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperObjectFactory;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.Database;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseRecord;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTable;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.DatabaseTableRecord;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.DealsWithPluginDatabaseSystem;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.PluginDatabaseSystem;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantCreateDatabaseException;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantLoadTableToMemoryException;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.DatabaseNotFoundException;
        import com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions.CantOpenDatabaseException;
        import com.bitdubai.fermat_cht_plugin.layer.middleware.chat.version_1.exceptions.CantInitializeChatMiddlewareDatabaseException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.UUID;
/**
 * The Class <code>com.bitdubai.fermat_cht_plugin.layer.middleware.chat.version_1.database.ChatMiddlewareDeveloperDatabaseFactory</code> have
 * contains the methods that the Developer Database Tools uses to show the information.
 * <p/>
 *
 * Created by Miguel Payarez - (miguel_payarez@hotmail.com) on 05/01/16.
 *
 * @version 1.0
 * @since Java JDK 1.7
 */
public class ChatMiddlewareDeveloperDatabaseFactory implements DealsWithPluginDatabaseSystem, DealsWithPluginIdentity {
    /**
     * DealsWithPluginDatabaseSystem Interface member variables.
     */
    PluginDatabaseSystem pluginDatabaseSystem;
    /**
     * DealsWithPluginIdentity Interface member variables.
     */
    UUID pluginId;
    Database database;
    /**
     * Constructor
     *
     * @param pluginDatabaseSystem
     * @param pluginId
     */
    public ChatMiddlewareDeveloperDatabaseFactory(PluginDatabaseSystem pluginDatabaseSystem, UUID pluginId) {
        this.pluginDatabaseSystem = pluginDatabaseSystem;
        this.pluginId = pluginId;
    }
    /**
     * This method open or creates the database i'll be working with
     *
     * @throws CantInitializeChatMiddlewareDatabaseException
     */
    public void initializeDatabase() throws CantInitializeChatMiddlewareDatabaseException {
        try {
             /*
              * Open new database connection
              */
            database = this.pluginDatabaseSystem.openDatabase(pluginId, pluginId.toString());
        } catch (CantOpenDatabaseException cantOpenDatabaseException) {
             /*
              * The database exists but cannot be open. I can not handle this situation.
              */
            throw new CantInitializeChatMiddlewareDatabaseException(cantOpenDatabaseException.getMessage());
        } catch (DatabaseNotFoundException e) {
             /*
              * The database no exist may be the first time the plugin is running on this device,
              * We need to create the new database
              */
            ChatMiddlewareDatabaseFactory chatMiddlewareDatabaseFactory = new ChatMiddlewareDatabaseFactory(pluginDatabaseSystem);
            try {
                  /*
                   * We create the new database
                   */
                database = chatMiddlewareDatabaseFactory.createDatabase(pluginId, pluginId.toString());
            } catch (CantCreateDatabaseException cantCreateDatabaseException) {
                  /*
                   * The database cannot be created. I can not handle this situation.
                   */
                throw new CantInitializeChatMiddlewareDatabaseException(cantCreateDatabaseException.getMessage());
            }
        }
    }
    public List<DeveloperDatabase> getDatabaseList(DeveloperObjectFactory developerObjectFactory) {
        /**
         * I only have one database on my plugin. I will return its name.
         */
        List<DeveloperDatabase> databases = new ArrayList<DeveloperDatabase>();
        databases.add(developerObjectFactory.getNewDeveloperDatabase("Chat", this.pluginId.toString()));
        return databases;
    }
    public List<DeveloperDatabaseTable> getDatabaseTableList(DeveloperObjectFactory developerObjectFactory) {
        List<DeveloperDatabaseTable> tables = new ArrayList<DeveloperDatabaseTable>();
        /**
         * Table Chats columns.
         */
        List<String> chatsColumns = new ArrayList<String>();

        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_ID_CHAT_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_ID_OBJETO_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_LOCAL_ACTOR_TYPE_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_LOCAL_ACTOR_PUB_KEY_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_REMOTE_ACTOR_TYPE_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_REMOTE_ACTOR_PUB_KEY_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_CHAT_NAME_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_STATUS_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_CREATION_DATE_COLUMN_NAME);
        chatsColumns.add(ChatMiddlewareDatabaseConstants.CHATS_LAST_MESSAGE_DATE_COLUMN_NAME);
        /**
         * Table Chats addition.
         */
        DeveloperDatabaseTable chatsTable = developerObjectFactory.getNewDeveloperDatabaseTable(ChatMiddlewareDatabaseConstants.CHATS_TABLE_NAME, chatsColumns);
        tables.add(chatsTable);

        /**
         * Table Message columns.
         */
        List<String> messageColumns = new ArrayList<String>();

        messageColumns.add(ChatMiddlewareDatabaseConstants.MESSAGE_ID_MENSAJE_COLUMN_NAME);
        messageColumns.add(ChatMiddlewareDatabaseConstants.MESSAGE_ID_CHAT_COLUMN_NAME);
        messageColumns.add(ChatMiddlewareDatabaseConstants.MESSAGE_TEXT_MESSAGE_COLUMN_NAME);
        messageColumns.add(ChatMiddlewareDatabaseConstants.MESSAGE_STATUS_COLUMN_NAME);
        messageColumns.add(ChatMiddlewareDatabaseConstants.MESSAGE_TYPE_COLUMN_NAME);
        messageColumns.add(ChatMiddlewareDatabaseConstants.MESSAGE_MESSAGE_DATE_COLUMN_NAME);
        /**
         * Table Message addition.
         */
        DeveloperDatabaseTable messageTable = developerObjectFactory.getNewDeveloperDatabaseTable(ChatMiddlewareDatabaseConstants.MESSAGE_TABLE_NAME, messageColumns);
        tables.add(messageTable);

        /**
         * Table Contacts columns.
         */
        List<String> contactsColumns = new ArrayList<String>();

        contactsColumns.add(ChatMiddlewareDatabaseConstants.CONTACTS_ID_CONTACT_COLUMN_NAME);
        contactsColumns.add(ChatMiddlewareDatabaseConstants.CONTACTS_REMOTE_NAME_COLUMN_NAME);
        contactsColumns.add(ChatMiddlewareDatabaseConstants.CONTACTS_ALIAS_COLUMN_NAME);
        contactsColumns.add(ChatMiddlewareDatabaseConstants.CONTACTS_REMOTE_ACTOR_TYPE_COLUMN_NAME);
        contactsColumns.add(ChatMiddlewareDatabaseConstants.CONTACTS_REMOTE_ACTOR_PUB_KEY_COLUMN_NAME);
        contactsColumns.add(ChatMiddlewareDatabaseConstants.CONTACTS_CREATION_DATE_COLUMN_NAME);
        /**
         * Table Contacts addition.
         */
        DeveloperDatabaseTable contactsTable = developerObjectFactory.getNewDeveloperDatabaseTable(ChatMiddlewareDatabaseConstants.CONTACTS_TABLE_NAME, contactsColumns);
        tables.add(contactsTable);


        return tables;
    }
    public List<DeveloperDatabaseTableRecord> getDatabaseTableContent(DeveloperObjectFactory developerObjectFactory, DeveloperDatabaseTable developerDatabaseTable) {
        /**
         * Will get the records for the given table
         */
        List<DeveloperDatabaseTableRecord> returnedRecords = new ArrayList<DeveloperDatabaseTableRecord>();
        /**
         * I load the passed table name from the SQLite database.
         */
        DatabaseTable selectedTable = database.getTable(developerDatabaseTable.getName());
        try {
            selectedTable.loadToMemory();
            List<DatabaseTableRecord> records = selectedTable.getRecords();
            for (DatabaseTableRecord row: records){
                List<String> developerRow = new ArrayList<String>();
                /**
                 * for each row in the table list
                 */
                for (DatabaseRecord field : row.getValues()){
                    /**
                     * I get each row and save them into a List<String>
                     */
                    developerRow.add(field.getValue());
                }
                /**
                 * I create the Developer Database record
                 */
                returnedRecords.add(developerObjectFactory.getNewDeveloperDatabaseTableRecord(developerRow));
            }
            /**
             * return the list of DeveloperRecords for the passed table.
             */
        } catch (CantLoadTableToMemoryException cantLoadTableToMemory) {
            /**
             * if there was an error, I will returned an empty list.
             */
            database.closeDatabase();
            return returnedRecords;
        } catch (Exception e){
            database.closeDatabase();
            return returnedRecords;
        }
        database.closeDatabase();
        return returnedRecords;
    }
    @Override
    public void setPluginDatabaseSystem(PluginDatabaseSystem pluginDatabaseSystem) {
        this.pluginDatabaseSystem = pluginDatabaseSystem;
    }
    @Override
    public void setPluginId(UUID pluginId) {
        this.pluginId = pluginId;
    }
}