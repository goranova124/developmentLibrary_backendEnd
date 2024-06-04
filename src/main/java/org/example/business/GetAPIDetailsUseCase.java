package org.example.business;

import org.example.domain.GetAPIDetailsResponse;

import java.sql.SQLException;

public interface GetAPIDetailsUseCase {
    GetAPIDetailsResponse getAPIDetails(String name) ;
}
