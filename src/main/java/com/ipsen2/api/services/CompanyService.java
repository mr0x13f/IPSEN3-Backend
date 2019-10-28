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
        return CompanyDAO.getCompany();
    }

    public static String postCompany(ArrayList<Object> cList) {
        return CompanyDAO.postCompany(cList);
    }
}
