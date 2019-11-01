package com.ipsen2.api.services;

import com.ipsen2.api.dao.CompanyDAO;
import com.ipsen2.api.models.Company;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal
 * @version 28/10/2019
 */
public class CompanyService {

    public static ArrayList<Company> getCompany() {
        return CompanyDAO.getCompany(null);
    }

    public static ArrayList<Company> getCompany(String companyId) {
        return CompanyDAO.getCompany(companyId);
    }

    public static String postCompany(Object c) {
        return CompanyDAO.postCompany(c);
    }

    public static String updateCompany(Object c) {
        return CompanyDAO.updateCompany(c);
    }

    public static String deleteCompany(String companyId) {
        return CompanyDAO.deleteCompany(companyId);
    }
}
