package com.ipsen2.api.services;

import com.ipsen2.api.dao.CompanyDAO;
import com.ipsen2.api.models.Company;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal, Tim W
 * @version 03/11/2019
 */
public class CompanyService {

    public static Company getCompany(String companyId) {
        return CompanyDAO.getCompany(companyId);
    }

    public static Company[] getCompanies() {
        return CompanyDAO.getCompanies();
    }

    public static String postCompany(Company c) {
        return CompanyDAO.postCompany(c);
    }

    public static String updateCompany(Company c) {
        return CompanyDAO.updateCompany(c);
    }

    public static String deleteCompany(String companyId) {
        return CompanyDAO.deleteCompany(companyId);
    }
}
