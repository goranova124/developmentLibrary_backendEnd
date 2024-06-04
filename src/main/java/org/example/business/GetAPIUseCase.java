package org.example.business;

import org.example.domain.GetAPISResponse;

import java.sql.SQLException;


public interface GetAPIUseCase {
    GetAPISResponse getApiResponse() throws SQLException;
}
