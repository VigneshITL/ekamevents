package com.itl.common.persistence;

import org.joda.time.DateTime;

public class AbstractEntity {

    private Long id;

    private String creator;

    private String changer;

    private DateTime createdOn;

    private DateTime changedOn;
}
