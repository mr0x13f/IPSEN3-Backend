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

    public static String postCompany(ArrayList<Object> cList) {
        return CompanyDAO.postCompany(cList);
    }

    public static String updateCompany(ArrayList<Object> cList) {
        return CompanyDAO.updateCompany(cList);
    }

    public static String deleteCompany(ArrayList<Object> cList) {
        return CompanyDAO.deleteCompany(cList);
    }
}
