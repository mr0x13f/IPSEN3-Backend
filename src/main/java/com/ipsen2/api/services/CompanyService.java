package com.ipsen2.api.services;

import com.ipsen2.api.models.Company;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal
 */
public class CompanyService {

    public static Company GETCompanyData() {
        //TODO implement DAO method.
        Company company = new Company(1, "1");
        return company;
    }
}
