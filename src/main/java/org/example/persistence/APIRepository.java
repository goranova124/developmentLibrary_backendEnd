package org.example.persistence;

import org.example.persistence.entity.APIEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface APIRepository {
    List<APIEntity> getAPIS() throws SQLException;

    Optional<APIEntity> getApiDetails(String name);
}
