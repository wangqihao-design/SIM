package com.simtech.sim.quartzclustercommon.entity;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.quartz.SchedulerException;
import org.quartz.SchedulerMetaData;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@DataAmount
@Data
public class SchedulerMetaDataCopier implements Serializable {
    private static final long serialVersionUID = 4203690002633917647L;
    private String schedName;
    private String schedInst;
    private Class<?> schedClass;
    private boolean isRemote;
    private boolean started;
    private boolean isInStandbyMode;
    private boolean shutdown;
    private Date startTime;
    private int numJobsExec;
    private Class<?> jsClass;
    private boolean jsPersistent;
    private boolean jsClustered;
    private Class<?> tpClass;
    private int tpSize;
    private String version;


    public String getSchedulerName() {
        return this.schedName;
    }

    public String getSchedulerInstanceId() {
        return this.schedInst;
    }

    public Class<?> getSchedulerClass() {
        return this.schedClass;
    }

    public Date getRunningSince() {
        return this.startTime;
    }

    public int getNumberOfJobsExecuted() {
        return this.numJobsExec;
    }

    public boolean isSchedulerRemote() {
        return this.isRemote;
    }

    public boolean isStarted() {
        return this.started;
    }

    public boolean isInStandbyMode() {
        return this.isInStandbyMode;
    }

    public boolean isShutdown() {
        return this.shutdown;
    }

    public Class<?> getJobStoreClass() {
        return this.jsClass;
    }

    public boolean isJobStoreSupportsPersistence() {
        return this.jsPersistent;
    }

    public boolean isJobStoreClustered() {
        return this.jsClustered;
    }

    public Class<?> getThreadPoolClass() {
        return this.tpClass;
    }

    public int getThreadPoolSize() {
        return this.tpSize;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        try {
            return this.getSummary();
        } catch (SchedulerException var2) {
            return "SchedulerMetaData: undeterminable.";
        }
    }

    public String getSummary() throws SchedulerException {
        StringBuilder str = new StringBuilder("Quartz Scheduler (v");
        str.append(this.getVersion());
        str.append(") '");
        str.append(this.getSchedulerName());
        str.append("' with instanceId '");
        str.append(this.getSchedulerInstanceId());
        str.append("'");
        if (this.isSchedulerRemote()) {
            str.append(" - access via RMI.");
        } else {
            str.append(" - running locally.");
        }

        str.append("\n");
        if (!this.isShutdown()) {
            if (this.getRunningSince() != null) {
                str.append("  Running since: ");
                str.append(this.getRunningSince());
            } else {
                str.append("  NOT STARTED.");
            }

            str.append("\n");
            if (this.isInStandbyMode()) {
                str.append("  Currently in standby mode.");
            } else {
                str.append("  Not currently in standby mode.");
            }
        } else {
            str.append("  Scheduler has been SHUTDOWN.");
        }

        str.append("\n");
        str.append("  Number of jobs executed: ");
        str.append(this.getNumberOfJobsExecuted());
        str.append("\n");
        str.append("  Using thread pool '");
        str.append("' - with ");
        str.append(this.getThreadPoolSize());
        str.append(" threads.");
        str.append("\n");
        str.append("' - which ");
        if (this.isJobStoreSupportsPersistence()) {
            str.append("supports persistence.");
        } else {
            str.append("does not support persistence.");
        }

        if (this.isJobStoreClustered()) {
            str.append(" and is clustered.");
        } else {
            str.append(" and is not clustered.");
        }

        str.append("\n");
        return str.toString();
    }

    public SchedulerMetaDataCopier copier(SchedulerMetaData metaData){
        BeanUtils.copyProperties(this, metaData);
        return this;
    }
}
