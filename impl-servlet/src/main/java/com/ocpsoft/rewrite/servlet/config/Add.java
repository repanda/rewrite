/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.rewrite.servlet.config;

import javax.servlet.http.Cookie;

import com.ocpsoft.rewrite.EvaluationContext;
import com.ocpsoft.rewrite.servlet.http.event.HttpServletRewrite;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public abstract class Add extends HttpOperation
{
   public static Add header(final String name, final String value)
   {
      return new Add() {
         @Override
         public void performHttp(final HttpServletRewrite event, final EvaluationContext context)
         {
            event.getResponse().addHeader(name, value);
         }
      };
   }

   public static Add dateHeader(final String name, final long value)
   {
      return new Add() {
         @Override
         public void performHttp(final HttpServletRewrite event, final EvaluationContext context)
         {
            event.getResponse().addDateHeader(name, value);
         }
      };
   }

   public static Add intHeader(final String name, final int value)
   {
      return new Add() {
         @Override
         public void performHttp(final HttpServletRewrite event, final EvaluationContext context)
         {
            event.getResponse().addIntHeader(name, value);
         }
      };
   }

   public static Add cookie(final Cookie cookie)
   {
      return new Add() {
         @Override
         public void performHttp(final HttpServletRewrite event, final EvaluationContext context)
         {
            event.getResponse().addCookie(cookie);
         }
      };
   }

}
