/*
 *
 *  * Copyright 2020 New Relic Corporation. All rights reserved.
 *  * SPDX-License-Identifier: Apache-2.0
 *
 */

package com.newrelic.agent.instrumentation.methodmatchers;

import org.objectweb.asm.commons.Method;

import java.util.Set;
import java.util.regex.Pattern;

/**
 * A method matcher that matches lambda methods.
 */
public final class LambdaMethodMatcher implements MethodMatcher {

    static final Pattern LAMBDA_METHOD_NAME_PATTERN = Pattern.compile("^\\$?(lambda|anonfun)\\$(?<name>.*)");

    @Override
    public boolean matches(int access, String name, String desc, Set<String> annotations) {
        return LAMBDA_METHOD_NAME_PATTERN.matcher(name).matches();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Method[] getExactMethods() {
        return null;
    }
}
