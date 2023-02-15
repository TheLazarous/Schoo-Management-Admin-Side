package com.schoolmanagementsystem.adminside.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class pageNavigations
{
    @GetMapping({ "/Invoicing" })
    public String invoicing() {
        return "invoicing";
    }

    @GetMapping({ "/Payments" })
    public String payments() {
        return "payments";
    }

    @GetMapping({ "/key" })
    public String key() {
        return "genKey";
    }

    @GetMapping({ "/AddService" })
    public String addService() {
        return "addService";
    }

    @GetMapping({ "/ServiceList" })
    public String ServiceList() {
        return "serviceList";
    }

    @GetMapping({ "/addTenantDocuments" })
    public String addtenantDocuments() {
        return "add_tenantdocuments";
    }

    @GetMapping({ "/LeaseForm" })
    public String getLeaseForm() {
        return "DeaseForm";
    }

    @GetMapping({ "/expireddocuments" })
    public String getExpiredDocuments() {
        return "expiredleasedocuments";
    }

    @GetMapping({ "/leasedocuments" })
    public String leaseDocuments() {
        return "lease_documents";
    }

    @GetMapping({ "/noticedocuments" })
    public String noticeDocuments() {
        return "notice_documents";
    }

    @GetMapping({ "/replydocuments" })
    public String replyDocuments() {
        return "replydocuments";
    }

    @GetMapping({ "/tenantDocuments" })
    public String tenantDocuments() {
        return "tenant_documents";
    }

    @GetMapping({ "/viewTenantDocuments" })
    public String viewTenantDocuments() {
        return "view_tenantDocuments";
    }

    @GetMapping({ "/viewFile" })
    public String viewFile() {
        return "viewFile";
    }

    @GetMapping({ "/otherForm" })
    public String OtherFile() {
        return "OtherForm";
    }

    @GetMapping({ "/AddSubject" })
    public String addLease() {
        return "AddSubject";
    }

    @GetMapping({ "/Edit-Lease" })
    public String editlease() {
        return "Edit-Lease";
    }

    @GetMapping({ "/Lease-Notices" })
    public String LeaseNotices() {
        return "Lease-Notices";
    }

    @GetMapping({ "/Lease-Form" })
    public String leaseform() {
        return "LeaseForm";
    }

    @GetMapping({ "/Terminate-Lease" })
    public String terminateLease() {
        return "Terminate-Lease";
    }

    @GetMapping({ "/View-Subjects" })
    public String viewLease() {
        return "View-Subjects";
    }

    @GetMapping({ "/View-Renewed" })
    public String viewRenewedLease() {
        return "View-Renewed-Lease";
    }

    @GetMapping({ "/Lease-Detail" })
    public String LeaseDetail() {
        return "LeaseDetail";
    }

    @GetMapping({ "/requestForm" })
    public String LodgeRequest() {
        return "requestForm";
    }

    @GetMapping({ "/request" })
    public String Request() {
        return "request";
    }

    @GetMapping({ "/schedule" })
    public String Schedule() {
        return "schedule";
    }

    @GetMapping({ "/overdueRequest" })
    public String OverdueRequest() {
        return "overdueRequest";
    }

    @GetMapping({ "/pending" })
    public String Pending() {
        return "pendingRequest";
    }

    @GetMapping({ "/attended" })
    public String Attended() {
        return "attendedRequest";
    }

    @GetMapping({ "/addProperty" })
    public String addProperty() {
        return "add_property";
    }

    @GetMapping({ "/addCompartment" })
    public String addCompartment() {
        return "add_compartment";
    }

    @GetMapping({ "/editProperty" })
    public String editProperty() {
        return "edit_property";
    }

    @GetMapping({ "/propertyList" })
    public String propertyList() {
        return "property-list";
    }

    @GetMapping({ "/viewCompartment" })
    public String viewCompartment() {
        return "view-compartment";
    }

    @GetMapping({ "/viewProperty" })
    public String viewProperty() {
        return "view-property";
    }

    @GetMapping({ "/View-Teachers" })
    public String tenantList() {
        return "ViewTeachers";
    }

    @GetMapping({ "/tenantDetail" })
    public String tenantDetails() {
        return "tenant_detail";
    }

    @GetMapping({ "/addTeacher" })
    public String addTenant() {
        return "AddTeacher";
    }

    @GetMapping({ "/assignProperty" })
    public String AssignProperty() {
        return "assign_property";
    }

    @GetMapping({ "/linechart" })
    public String getNabar() {
        return "linechart";
    }
}