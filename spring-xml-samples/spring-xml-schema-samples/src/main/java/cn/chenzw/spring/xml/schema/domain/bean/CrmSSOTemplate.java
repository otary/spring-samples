package cn.chenzw.spring.xml.schema.domain.bean;

import cn.chenzw.spring.xml.schema.support.SSO;

/**
 * 自定义单点类
 *
 * @author chenzw
 */
@SSO(source = {"fz_crm", "fz_oa"})
public class CrmSSOTemplate {

    public boolean validate() {
        return false;
    }

}
