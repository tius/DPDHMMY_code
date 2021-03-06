/*
 * Copyright  2002-2004 The Apache Software Foundation
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

/*
 * Since the initial version of this file was deveolped on the clock on
 * an NSF grant I should say the following boilerplate:
 *
 * This material is based upon work supported by the National Science
 * Foundaton under Grant No. EIA-0196404. Any opinions, findings, and
 * conclusions or recommendations expressed in this material are those
 * of the author and do not necessarily reflect the views of the
 * National Science Foundation.
 */

package org.apache.tools.ant.taskdefs.optional.unix;

import org.apache.tools.ant.BuildException;

/**
 * Chgrp equivalent for unix-like environments.
 *
 *
 * @since Ant 1.6
 *
 * @ant.task category="filesystem"
 */
public class Chgrp extends AbstractAccessTask {

    private boolean haveGroup = false;

    /**
     * Chgrp task for setting unix group of a file.
     */
    public Chgrp() {
        super.setExecutable("chgrp");
    }

    /**
     * Set the group atribute.
     *
     * @param group    The new group for the file(s) or directory(ies)
     */
    public void setGroup(String group) {
        createArg().setValue(group);
        haveGroup = true;
    }

    /**
     * Ensure that all the required arguments and other conditions have
     * been set.
     */
    protected void checkConfiguration() {
        if (!haveGroup) {
            throw new BuildException("Required attribute group not set in "
                                     + "chgrp", getLocation());
        }
        super.checkConfiguration();
    }

    /**
     * We don't want to expose the executable atribute, so overide it.
     *
     * @param e User supplied executable that we won't accept.
     */
    public void setExecutable(String e) {
        throw new BuildException(getTaskType()
                                 + " doesn\'t support the executable"
                                 + " attribute", getLocation());
    }
}
