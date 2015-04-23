//--------------------------------------------------------------------------
// Copyright (c) 2010-2020, En.dennisit or Cn.苏若年
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
// Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
// Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
// Neither the name of the dennisit nor the names of its contributors
// may be used to endorse or promote products derived from this software
// without specific prior written permission.
// Author: dennisit@163.com | dobby | 苏若年
//--------------------------------------------------------------------------
package com.plugin.spring.velocity.views;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

import java.util.Map;

/**
 * Description: Description: extends velocity view , with common tools
 * @author dennisit@163.com
 * @version 1.0
 */
public class ExtendsVelocityWithToolsViewResolver extends VelocityLayoutViewResolver {

    /** config velocity tool */
    private Map<String, Object> velocityTools;

    @Override
    protected Class requiredViewClass() {
        return ExtendsVelocityWithToolsView.class;
    }


    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        ExtendsVelocityWithToolsView view = (ExtendsVelocityWithToolsView) super.buildView(viewName);
        if (this.velocityTools != null) {
            view.setVelocityTools(this.velocityTools);
        }
        return view;
    }

    public Map<String, Object> getVelocityTools() {
        return velocityTools;
    }

    public void setVelocityTools(Map<String, Object> velocityTools) {
        this.velocityTools = velocityTools;
    }


}
