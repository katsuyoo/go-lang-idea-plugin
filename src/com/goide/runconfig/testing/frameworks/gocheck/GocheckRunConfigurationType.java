/*
 * Copyright 2013-2015 Sergey Ignatov, Alexander Zolotov, Mihai Toader, Florin Patan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.goide.runconfig.testing.frameworks.gocheck;

import com.goide.GoIcons;
import com.goide.runconfig.testing.GoTestConfigurationFactoryBase;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.extensions.Extensions;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class GocheckRunConfigurationType extends ConfigurationTypeBase {

  public GocheckRunConfigurationType() {
    super("GocheckRunConfiguration", "Gocheck Test", "Gocheck run configuration", GoIcons.TEST_RUN);
    addFactory(new GoTestConfigurationFactoryBase(this) {
      @NotNull
      public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new GocheckRunConfiguration(project, "Gocheck Test", getInstance());
      }
    });
  }

  @NotNull
  public static GocheckRunConfigurationType getInstance() {
    return Extensions.findExtension(CONFIGURATION_TYPE_EP, GocheckRunConfigurationType.class);
  }
}
