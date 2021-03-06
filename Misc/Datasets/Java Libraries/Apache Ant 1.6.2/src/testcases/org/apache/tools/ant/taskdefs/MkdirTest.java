/*
 * Copyright  2000-2001,2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildFileTest;

/**
 */
public class MkdirTest extends BuildFileTest {

    public MkdirTest(String name) {
        super(name);
    }

    public void setUp() {
        configureProject("src/etc/testcases/taskdefs/mkdir.xml");
    }

    public void test1() {
        expectBuildException("test1", "required argument missing");
    }

    public void test2() {
        expectBuildException("test2", "directory already exists as a file");
    }

    public void test3() {
        executeTarget("test3");
        java.io.File f = new java.io.File(getProjectDir(), "testdir.tmp");
        if (!f.exists() || !f.isDirectory()) {
            fail("mkdir failed");
        } else {
            f.delete();
        }
    }
}
