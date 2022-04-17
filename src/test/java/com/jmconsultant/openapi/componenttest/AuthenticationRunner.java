package com.jmconsultant.openapi.componenttest;

import com.intuit.karate.junit5.Karate;

public class AuthenticationRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
