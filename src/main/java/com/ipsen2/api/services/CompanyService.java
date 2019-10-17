package com.ipsen2.api.services;

import com.ipsen2.api.dao.CompanyDAO;
import com.ipsen2.api.models.Company;

import java.util.ArrayList;

/**
 * Service for handling and completing requests revolving companies.
 *
 * @author TimvHal
 * @version 14/10/2019
 */
public class CompanyService {

    public static ArrayList<Company> GETCompanyList() {
        return CompanyDAO.GETCompanyData();
    }

    public static String POSTVehicle(ArrayList<Object> cList) {
        return CompanyDAO.POSTVehicle(cList);
    }
}
