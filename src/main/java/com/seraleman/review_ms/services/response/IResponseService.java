package com.seraleman.review_ms.services.response;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;

public interface IResponseService {

    public ResponseEntity<Map<String, Object>> list(List<?> objs);

    public ResponseEntity<Map<String, Object>> found(Object obj);

    public ResponseEntity<Map<String, Object>> empty();

    public ResponseEntity<Map<String, Object>> notFound(String id);

    public ResponseEntity<Map<String, Object>> created(Object obj);

    public ResponseEntity<Map<String, Object>> notCreated();

    public ResponseEntity<Map<String, Object>> updated(Object obj);

    public ResponseEntity<Map<String, Object>> notUpdated();

    public ResponseEntity<Map<String, Object>> deleted(String id);

    public ResponseEntity<Map<String, Object>> errorDataAccess(DataAccessException e);

}
