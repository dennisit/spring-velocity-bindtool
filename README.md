# spring-velocity-bindtool

【spring-velocity-bind】


    <!-- how to config -->

    <bean id="velocityConfig" class="org.springframework.web.servlet.view.velocity.VelocityConfigurer">
        <property name="resourceLoaderPath" value="." />
        <property name="configLocation" value="classpath:template/velocity.properties" />
        <property name="velocityProperties">
            <props>
                <prop key="input.encoding">UTF-8</prop>
                <prop key="output.encoding">UTF-8</prop>
                <prop key="contentType">text/html;charset=UTF-8</prop>
            </props>
        </property>
    </bean>

    <bean id="velocityViewResolver" class="com.plugin.spring.velocity.views.ExtendsVelocityWithToolsViewResolver">
        <property name="cache" value="false" />
        <property name="suffix" value=".vm" />
        <property name="prefix" value="/WEB-INF/vm/" />
        <property name="layoutUrl" value="/WEB-INF/vm/layout/default.vm" />
        <property name="exposeSpringMacroHelpers" value="true" />
        <property name="dateToolAttribute" value="dateTool" />
        <property name="numberToolAttribute" value="numberTool" />
        <property name="contentType" value="text/html;charset=UTF-8" />
        <property name="velocityUrl" ref="velocityUrl" />
        <property name="velocityTools" ref="velocityTools" />
    </bean>


    <bean name="velocityTools" class="java.util.HashMap">
        <constructor-arg>
            <map>
                <entry key="stringUtils">
                    <bean class="org.apache.commons.lang.StringUtils" />
                </entry>
                <entry key="stringEscapeUtils">
                    <bean class="org.apache.commons.lang.StringEscapeUtils" />
                </entry>
                <entry key="commonsDateFormatUtils">
                    <bean class="org.apache.commons.lang.time.DateFormatUtils" />
                </entry>
                <entry key="dateUtils">
                    <bean class="org.apache.commons.lang.time.DateUtils" />
                </entry>
            </map>
        </constructor-arg>
    </bean>


