package com.mycompany.app.service;

import com.mycompany.app.model.ValidateResultObject;
import com.mycompany.app.util.Validate;

public class InputService {
    private Validate validator = new Validate();

    public InputService() {
    }

    // TODO: return a HashSet of result objs that can return contents to identify
    // which views will be sent
    public ValidateResultObject validate(String day, String month, String year) {
        ValidateResultObject dayResult = validator.day(day, month, year);
    }
}
