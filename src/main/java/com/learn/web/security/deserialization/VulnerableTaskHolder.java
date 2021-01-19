package com.learn.web.security.deserialization;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class VulnerableTaskHolder implements Serializable {

    private static final long serialVersionUID = 2;

    private String taskAction;

    public VulnerableTaskHolder(String taskAction) {
        super();
        this.taskAction = taskAction;
    }

    private void readObject(ObjectInputStream stream) throws Exception {
        //deserialize data so taskName and taskAction are available
        stream.defaultReadObject();

        //blindly run some code. #code injection
        Runtime.getRuntime().exec(taskAction);
    }
}
