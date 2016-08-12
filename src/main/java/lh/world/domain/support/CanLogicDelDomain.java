package lh.world.domain.support;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by lh on 2016/8/8.
 */
@MappedSuperclass
public abstract class CanLogicDelDomain extends BaseDomain {
    @Column(name = "del")
    protected Boolean del = false;

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }
}
