package com.ibotta.gradle.aop.brokenkapt.logic;

import com.ibotta.gradle.aop.brokenkapt.Counter;

/**
 * To reproduce the issue, build the project from a clean state once (or run the app)
 * and then make a change inside the method of this class. Build or run again, as to
 * trigger an incremental compilation. KAPT will fail with unresolved references.
 */
public class Controller {

    private final Counter counter = new Counter();

    public void process() {
        counter.count();
    }
}
