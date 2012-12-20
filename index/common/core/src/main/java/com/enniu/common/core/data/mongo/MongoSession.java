package com.enniu.common.core.data.mongo;

import org.springframework.stereotype.Repository;

@Repository("mongoSession")
public class MongoSession {/*
    private static String counterCollectionName = "CounterCollection";

    @Autowired
    private MongoCfg      mongoCfg;

    private DB            _db;

    private DB getDB() throws Exception {
        if (_db == null) {
            Mongo mongo = new Mongo(mongoCfg.getHost(), mongoCfg.getPort());
            _db = mongo.getDB(mongoCfg.getDbName());
        }
        return _db;
    }

    *//**
     * 运行命令
     * @param cmd
     * @return
     * @throws MongoException
     * @throws Exception
     *//*
    public CommandResult command(BasicDBObject cmd) throws MongoException, Exception {
        return getDB().command(cmd);
    }

    *//**
     * 获得集合
     * @param collName
     * @return
     * @throws Exception
     *//*
    public DBCollection getCollection(String collName) throws Exception {
        return getDB().getCollection(collName);
    }

    *//**
     * 插入一条记录
     * @param collName
     * @param obj
     * @throws MongoException
     * @throws Exception
     *//*
    public void insert(String collName, DBObject obj) throws MongoException, Exception {
        getCollection(collName).insert(obj);
    }

    *//**
     * 批量插入
     * @param collName
     * @param listDB
     * @throws MongoException
     * @throws Exception
     *//*
    public void insertBatch(String collName, List<DBObject> listDB) throws MongoException,
            Exception {
        if (listDB == null || listDB.isEmpty()) {
            return;
        }
        getCollection(collName).insert(listDB);
    }

    *//**
     * 根据DBObject表达的条件进行删除
     * @param collName
     * @param query
     * @throws MongoException
     * @throws Exception
     *//*
    public void delete(String collName, DBObject query) throws MongoException, Exception {
        getCollection(collName).remove(query);
    }

    *//**
     * 取得集合的记录条数
     * @param collName
     * @return
     * @throws MongoException
     * @throws Exception
     *//*
    public long getCollectionCount(String collName) throws MongoException, Exception {
        return getCollection(collName).getCount();
    }

    public long getCount(String collName, DBObject query) throws MongoException, Exception {
        return getCollection(collName).getCount(query);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findMap(String collName, DBObject qry, DBObject dbo,
                                             int startnum, int pageSize) throws MongoException,
            Exception {
        DBCursor cur = getCollection(collName).find(qry).sort(dbo).skip(startnum).limit(pageSize);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (cur == null) {
            return list;
        }
        for (; cur.hasNext();) {
            DBObject obj = cur.next();
            Map<String, Object> maps = obj.toMap();
            list.add(maps);
        }
        return list;
    }

    public List<DBObject> find(String collName, DBObject qry, DBObject dbo, Integer startnum,
                               Integer pageSize) throws MongoException, Exception {
        DBCursor cur = getCollection(collName).find(qry);
        if (dbo != null)
            cur.sort(dbo);
        if (startnum != null)
            cur.skip(startnum);
        if (pageSize != null)
            cur.limit(pageSize);
        List<DBObject> list = new ArrayList<DBObject>();
        if (cur == null) {
            return list;
        }
        for (; cur.hasNext();) {
            DBObject obj = cur.next();
            list.add(obj);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> find(String collName, BasicDBObject query)
            throws MongoException, Exception {
        DBCursor cur = getCollection(collName).find(query);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (cur == null) {
            return list;
        }
        for (; cur.hasNext();) {
            DBObject obj = cur.next();
            Map<String, Object> maps = obj.toMap();
            list.add(maps);
        }
        return list;
    }

    public void updateMulti(String collName, DBObject setFields, DBObject whereFields)
            throws MongoException, Exception {
        getCollection(collName).updateMulti(setFields, whereFields);
    }

    public void update(String collName, DBObject query, DBObject object) throws MongoException,
            Exception {
        DBObject updateSetValue = new BasicDBObject("$set", object);
        getCollection(collName).update(query, updateSetValue);
    }

    public DBObject getById(String collName, Long id) throws MongoException, Exception {
        DBObject obj = new BasicDBObject();
        obj.put("_id", id);
        DBObject result = getCollection(collName).findOne(obj);
        return result;
    }

    public boolean exists(String collName, BasicDBObject query) throws MongoException, Exception {
        DBObject result = getCollection(collName).findOne(query);
        return (result != null);
    }

    public void saveFile(InputStream in, String filename) throws MongoException, Exception {
        GridFS f = new GridFS(getDB());
        GridFSFile mongofile = f.createFile(in, filename);
        mongofile.put("filename", filename);
        mongofile.save();
    }

    public void deleteFile(long fileId) throws MongoException, Exception {
        GridFS f = getGridFS();
        BasicDBObject obj = new BasicDBObject();
        obj.put("_id", fileId);
        f.remove(obj);
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#saveFile(java.io.File, java.lang.String)
     
    public void saveFile(File file, String filename) throws MongoException, Exception {
        GridFS f = getGridFS();
        try {
            GridFSFile mongofile = f.createFile(file);
            mongofile.put("filename", filename);
            mongofile.put("uploadDate", new Date());
            System.out.println("--------" + new Date());
            mongofile.put("contentType", "JPG");
            mongofile.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#saveFile(byte[], java.lang.String)
     
    public void saveFile(byte[] bytes, String filename) throws MongoException, Exception {
        GridFS gridFS = getGridFS();
        GridFSFile gridFSFile = gridFS.createFile(bytes);
        gridFSFile.put("filename", filename);
        gridFSFile.save();
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#findFilesByName(java.lang.String)
     
    public List<GridFSDBFile> findFilesByName(String fileName) throws MongoException, Exception {
        GridFS f = getGridFS();
        List<GridFSDBFile> list = f.find(fileName);
        return list;
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#findFileByName(java.lang.String)
     
    public GridFSDBFile findFileByName(String filename) throws MongoException, Exception {
        return getGridFS().findOne(filename);
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#findFileByName(java.lang.String)
     
    public GridFSDBFile findFileById(long fileId) throws MongoException, Exception {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", fileId);
        return getGridFS().findOne(query);
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#getFileInputStream(java.lang.String)
     
    public InputStream getFileInputStream(String filename) throws MongoException, Exception {
        GridFSDBFile file = getGridFS().findOne(filename);
        if (file == null) {
            return null;
        }
        return file.getInputStream();
    }

    public byte[] getFileBytes(long fileId) throws IOException, MongoException, Exception {
        GridFSDBFile file = findFileById(fileId);
        if (file == null) {
            return null;
        }
        InputStream is = file.getInputStream();
        return IOUtils.toByteArray(is);
    }

    
     * (non-Javadoc)
     * 
     * @see util.MongodService#getGridFS()
     
    public GridFS getGridFS() throws MongoException, Exception {
        GridFS gridFS = new GridFS(getDB());
        return gridFS;
    }

    public long getFileCount() throws MongoException, Exception {
        DBCursor cursor = getGridFS().getFileList();
        if (cursor == null) {
            return 0;
        } else {
            return cursor.count();
        }
    }

    public List<GridFSDBFile> getAllFiles() throws MongoException, Exception {
        return getGridFS().find(new BasicDBObject());
    }

    public List<GridFSDBFile> findFiles(BasicDBObject query, int pageNumber, int pageSize)
            throws MongoException, Exception {
        DBCursor cur = getGridFS().getFileList(query).skip((pageNumber - 1) * pageSize)
                .limit(pageSize);
        List<GridFSDBFile> result = new ArrayList<GridFSDBFile>();
        while (cur.hasNext()) {
            result.add((GridFSDBFile) cur.next());
        }
        return result;
    }

    public void removeFile(String filename) throws MongoException, Exception {
        getGridFS().remove(filename);
    }

    public void removeFile(BasicDBObject query) throws MongoException, Exception {
        getGridFS().remove(query);
    }

    public void removeFile(ObjectId id) throws MongoException, Exception {
        getGridFS().remove(id);
    }

    public void removeAllFile() throws MongoException, Exception {
        getGridFS().remove(new BasicDBObject());
    }

    public long increaseAndReturn(String counterName) throws MongoException, Exception {
        DBObject update = new BasicDBObject("$inc", new BasicDBObject("counter", 1));
        DBObject query = new BasicDBObject("_id", counterName);
        DBObject result = getCollection(counterCollectionName).findAndModify(query, update);
        if (result == null) {
            DBObject doc = new BasicDBObject();
            doc.put("counter", 1L);
            doc.put("_id", counterName);
            insert(counterCollectionName, doc);
        }
        result = getCollection(counterCollectionName).findAndModify(query, update);
        return (Long) result.get("counter");
    }

    //	public long increaseAndReturn(String collName ,String counterName) throws MongoException, Exception {
    //		DBObject update = new BasicDBObject("$inc", new BasicDBObject("counter", 1));
    //		DBObject query = new BasicDBObject("_id", counterName);
    //		DBObject result = getCollection(collName).findAndModify(query, update);
    //		return (Long)result.get("counter");
    //	}
*/}
