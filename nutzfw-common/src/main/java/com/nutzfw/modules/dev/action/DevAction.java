package com.nutzfw.modules.dev.action;

import com.nutzfw.core.common.annotation.AutoCreateMenuAuth;
import com.nutzfw.core.common.cons.Cons;
import com.nutzfw.core.common.filter.CheckRoleAndSession;
import com.nutzfw.modules.common.action.BaseAction;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

/**
 * @author 黄川 huchuc@vip.qq.com
 * @date 2017/12/25  19:30
 */
@IocBean
@At("/dev/")
@Filters(@By(type = CheckRoleAndSession.class, args = {Cons.SESSION_USER_KEY, Cons.SESSION_USER_ROLE}))
public class DevAction extends BaseAction {


    /**
     * 开发人员首页
     */
    @GET
    @At("index")
    @Ok("btl:WEB-INF/view/dev/index.html")
    @RequiresPermissions("dev.index")
    @AutoCreateMenuAuth(name = "开发者文档", icon = "fa-eye", parentPermission = "sys.index")
    public void index() {

    }

}
