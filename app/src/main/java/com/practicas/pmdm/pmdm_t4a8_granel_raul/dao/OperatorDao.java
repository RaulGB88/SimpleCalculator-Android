package com.practicas.pmdm.pmdm_t4a8_granel_raul.dao;

import com.practicas.pmdm.pmdm_t4a8_granel_raul.model.Operator;

import java.util.ArrayList;
import java.util.List;

public class OperatorDao {

    public List<Operator> getOperatorsList() {

        ArrayList<Operator> operatorsList = new ArrayList<>();
        operatorsList.add(new Operator(1, "SUMAR", "+"));
        operatorsList.add(new Operator(2, "RESTAR", "-"));
        operatorsList.add(new Operator(3, "MULTIPLICAR", "*"));
        operatorsList.add(new Operator(4, "DIVIDIR", "/"));

        return operatorsList;
    }
}
