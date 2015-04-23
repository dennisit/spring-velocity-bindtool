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

import org.apache.velocity.context.Context;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Description:
 * @author dennisit@163.com
 * @version 1.0
 */
public class ExtendsVelocityWithToolsView extends VelocityLayoutView {


    /** config velocity tool */
    private Map<String, Object> velocityTools;

    /**
     * bind velocityTools to context
     * @param context
     */
    private void mergeContext(Context context) {
        merge(context, velocityTools);
    }


    private void merge(Context context, Map<String, Object> map) {
        if (map != null) {
            for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
                context.put(stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }
        }
    }

    @Override
    protected void doRender(Context context, HttpServletResponse response) throws Exception {
        mergeContext(context);
        super.doRender(context, response);
    }

    public Map<String, Object> getVelocityTools() {
        return velocityTools;
    }

    public void setVelocityTools(Map<String, Object> velocityTools) {
        this.velocityTools = velocityTools;
    }

}
