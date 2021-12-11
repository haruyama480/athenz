//
// This file generated by rdl 1.5.2. Do not modify!
//

package com.yahoo.athenz.msd;
import com.yahoo.rdl.*;

public class MSDSchema {

    private final static Schema INSTANCE = build();
    public static Schema instance() {
        return INSTANCE;
    }

    private static Schema build() {
        SchemaBuilder sb = new SchemaBuilder("MSD");
        sb.version(1);
        sb.namespace("com.yahoo.athenz.msd");
        sb.comment("Copyright The Athenz Authors Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms. The Micro Segmentation Defense (MSD) API");

        sb.stringType("SimpleName")
            .comment("Copyright The Athenz Authors Licensed under the terms of the Apache version 2.0 license. See LICENSE file for terms. Common name types used by several API definitions A simple identifier, an element of compound name.")
            .pattern("[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("CompoundName")
            .comment("A compound name. Most names in this API are compound names.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("DomainName")
            .comment("A domain name is the general qualifier prefix, as its uniqueness is managed.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityName")
            .comment("An entity name is a short form of a resource name, including only the domain and entity.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("EntityList")
            .comment("An Entity list is comma separated compound Names")
            .pattern("(([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*,)*([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ServiceName")
            .comment("A service name will generally be a unique subdomain.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ActionName")
            .comment("An action (operation) name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("ResourceName")
            .comment("A resource name Note that the EntityName part is optional, that is, a domain name followed by a colon is valid resource name.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*(:([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*)?");

        sb.stringType("YBase64")
            .comment("The Y-specific URL-safe Base64 variant.")
            .pattern("[a-zA-Z0-9\\._-]+");

        sb.stringType("YEncoded")
            .comment("YEncoded includes ybase64 chars, as well as = and %. This can represent a user cookie and URL-encoded values.")
            .pattern("[a-zA-Z0-9\\._%=-]*");

        sb.stringType("AuthorityName")
            .comment("Used as the prefix in a signed assertion. This uniquely identifies a signing authority.")
            .pattern("([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("PathElement")
            .comment("A uri-safe path element")
            .pattern("[a-zA-Z0-9-\\._~=+@$,:]*");

        sb.stringType("TransportPolicySubjectDomainName")
            .comment("DomainName in TransportPolicySubject should allow * to indicate ANY")
            .pattern("\\*|([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.stringType("TransportPolicySubjectServiceName")
            .comment("ServiceName in TransportPolicySubject should allow * to indicate ANY")
            .pattern("\\*|([a-zA-Z0-9_][a-zA-Z0-9_-]*\\.)*[a-zA-Z0-9_][a-zA-Z0-9_-]*");

        sb.enumType("TransportPolicyEnforcementState")
            .comment("Types of transport policy enforcement states")
            .element("ENFORCE")
            .element("REPORT");

        sb.enumType("TransportPolicyProtocol")
            .comment("Types of transport policy protocols")
            .element("TCP")
            .element("UDP");

        sb.enumType("TransportPolicyValidationStatus")
            .comment("Validation Status of transport policy vs network policy")
            .element("VALID")
            .element("INVALID")
            .element("PARTIAL");

        sb.enumType("TransportPolicyTrafficDirection")
            .comment("Types of transport policy traffic direction")
            .element("INGRESS")
            .element("EGRESS");

        sb.structType("TransportPolicySubject")
            .comment("Subject for a transport policy")
            .field("domainName", "TransportPolicySubjectDomainName", false, "Name of the domain")
            .field("serviceName", "TransportPolicySubjectServiceName", false, "Name of the service");

        sb.structType("TransportPolicyCondition")
            .comment("Transport policy condition. Used to specify additional restrictions for the subject of a transport policy")
            .field("enforcementState", "TransportPolicyEnforcementState", false, "State of transport policy enforcement ( ENFORCE / REPORT )")
            .arrayField("instances", "String", true, "Acts as restrictions. If present, this transport policy should be restricted to only mentioned instances.");

        sb.structType("PolicyPort")
            .comment("generic policy port. Will be used by TransportPolicyPort and NetworkPolicyPort structs")
            .field("port", "Int32", false, "Start port of the port range. port and endPort will have same values for a single port definition.")
            .field("endPort", "Int32", false, "End port of the port range. port and endPort will have same values for a single port definition.");

        sb.structType("TransportPolicyPort", "PolicyPort")
            .comment("Transport policy port")
            .field("protocol", "TransportPolicyProtocol", false, "Protocol for this transport policy");

        sb.structType("TransportPolicyMatch")
            .comment("Selector for the subject of a transport policy")
            .field("athenzService", "TransportPolicySubject", false, "Subject where this transport policy applies")
            .arrayField("conditions", "TransportPolicyCondition", false, "List of additional requirements for restrictions. Requirements are ANDed.");

        sb.structType("TransportPolicyPeer")
            .comment("Source or destination for a transport policy")
            .arrayField("athenzServices", "TransportPolicySubject", false, "List of transport policy subjects")
            .arrayField("ports", "TransportPolicyPort", false, "List of network traffic port part of this transport policy");

        sb.structType("TransportPolicyEntitySelector")
            .comment("Entity to which a transport policy applies. Describes the subject and port(s) for a transport policy.")
            .field("match", "TransportPolicyMatch", false, "Requirements for selecting the subject for this transport policy.")
            .arrayField("ports", "TransportPolicyPort", false, "List of network traffic port of the subject eligible for the transport policy");

        sb.structType("TransportPolicyIngressRule")
            .comment("Transport policy ingress rule")
            .field("id", "Int64", false, "Assertion id associated with this transport policy")
            .field("lastModified", "Timestamp", false, "Last modification timestamp of this transport policy")
            .field("entitySelector", "TransportPolicyEntitySelector", false, "Describes the entity to which this transport policy applies")
            .field("from", "TransportPolicyPeer", false, "Source of network traffic");

        sb.structType("TransportPolicyEgressRule")
            .comment("Transport policy egress rule")
            .field("id", "Int64", false, "Assertion id associated with this transport policy")
            .field("lastModified", "Timestamp", false, "Last modification timestamp of this transport policy")
            .field("entitySelector", "TransportPolicyEntitySelector", false, "Entity to which this transport policy applies")
            .field("to", "TransportPolicyPeer", false, "Destination of network traffic");

        sb.structType("TransportPolicyRules")
            .comment("Transport policy containing ingress and egress rules")
            .arrayField("ingress", "TransportPolicyIngressRule", false, "List of ingress rules")
            .arrayField("egress", "TransportPolicyEgressRule", false, "List of egress rules");

        sb.structType("TransportPolicyValidationRequest")
            .comment("Transport policy request object to be validated")
            .field("entitySelector", "TransportPolicyEntitySelector", false, "Describes the entity to which this transport policy applies")
            .field("peer", "TransportPolicyPeer", false, "source or destination of the network traffic depending on direction")
            .field("id", "Int64", true, "If present, assertion id associated with this transport policy")
            .field("trafficDirection", "TransportPolicyTrafficDirection", false, "");

        sb.structType("TransportPolicyValidationResponse")
            .comment("Response object of transport policy rule validation")
            .field("status", "TransportPolicyValidationStatus", false, "")
            .arrayField("errors", "String", true, "")
            .field("updateTime", "Timestamp", true, "most recent update timestamp in the backend")
            .field("id", "Int64", true, "If present, assertion id associated with the transport policy");

        sb.structType("TransportPolicyValidationResponseList")
            .comment("List of TransportPolicyValidationResponse")
            .arrayField("responseList", "TransportPolicyValidationResponse", false, "list of transport policy validation response");

        sb.enumType("StaticWorkloadType")
            .comment("Enum representing defined types of static workloads.")
            .element("VIP")
            .element("ENTERPRISE_APPLIANCE")
            .element("CLOUD_LB")
            .element("CLOUD_NAT")
            .element("EXTERNAL_APPLIANCE");

        sb.structType("DynamicWorkload")
            .comment("workload type describing workload bootstrapped with an identity")
            .field("domainName", "DomainName", false, "name of the domain")
            .field("serviceName", "EntityName", false, "name of the service")
            .field("uuid", "String", false, "unique identifier for the workload, usually defined by provider")
            .arrayField("ipAddresses", "String", false, "list of IP addresses associated with the workload, optional for getWorkloadsByIP API call")
            .field("hostname", "String", false, "hostname associated with the workload")
            .field("provider", "String", false, "infrastructure provider e.g. Kubernetes, AWS, Azure, openstack etc.")
            .field("updateTime", "Timestamp", false, "most recent update timestamp in the backend")
            .field("certExpiryTime", "Timestamp", false, "certificate expiry time (ex: getNotAfter)")
            .field("certIssueTime", "Timestamp", true, "certificate issue time (ex: getNotBefore)");

        sb.structType("Workload", "DynamicWorkload")
            .comment("kept for backward compatibility sake. Will be eventually deprecated in favor of DynamicWorkload");

        sb.structType("StaticWorkload")
            .comment("workload type describing workload indirectly associated with an identity ( without bootstrap )")
            .field("domainName", "DomainName", false, "name of the domain")
            .field("serviceName", "EntityName", false, "name of the service")
            .field("type", "StaticWorkloadType", false, "value representing one of the StaticWorkloadType enum")
            .arrayField("ipAddresses", "String", true, "list of IP addresses associated with the workload, optional for getWorkloadsByIP API call")
            .field("name", "String", true, "name associated with the workload. In most cases will be a FQDN")
            .field("updateTime", "Timestamp", true, "most recent update timestamp in the backend");

        sb.structType("WorkloadOptions")
            .field("ipChanged", "Bool", false, "boolean flag to signal a change in IP state");

        sb.structType("Workloads")
            .comment("list of workloads")
            .arrayField("workloadList", "Workload", false, "list of workloads")
            .arrayField("dynamicWorkloadList", "DynamicWorkload", true, "list of dynamic workloads")
            .arrayField("staticWorkloadList", "StaticWorkload", true, "list of static workloads");

        sb.enumType("NetworkPolicyChangeEffect")
            .comment("IMPACT indicates that a change in network policy will interfere with workings of one or more transport policies NO_IMAPCT indicates that a change in network policy will not interfere with workings of any transport policy")
            .element("IMPACT")
            .element("NO_IMPACT");

        sb.structType("IPBlock")
            .comment("Struct representing ip blocks used by network policy in CIDR (Classless inter-domain routing) format")
            .field("cidr", "String", false, "cidr notation. can be used for ipv4 or ipv6");

        sb.structType("NetworkPolicyPort", "PolicyPort")
            .comment("network policy port.")
            .field("protocol", "TransportPolicyProtocol", false, "protocol used by the network policy");

        sb.structType("NetworkPolicyChangeImpactRequest")
            .comment("struct representing input details for evaluating network policies change impact on transport policies")
            .arrayField("from", "IPBlock", false, "from ip address range list in cidr format")
            .arrayField("to", "IPBlock", false, "to ip address range list in cidr format")
            .arrayField("sourcePorts", "NetworkPolicyPort", false, "list of source ports")
            .arrayField("destinationPorts", "NetworkPolicyPort", false, "list of destination ports");

        sb.structType("NetworkPolicyChangeImpactDetail")
            .field("domain", "DomainName", false, "Name of the domain of the corresponding transport policy")
            .field("policy", "EntityName", false, "Name of the Athenz policy corresponding to transport policy")
            .field("transportPolicyId", "Int64", false, "Unique id of the transport policy");

        sb.structType("NetworkPolicyChangeImpactResponse")
            .comment("struct representing response of evaluating network policies change impact on transport policies")
            .field("effect", "NetworkPolicyChangeEffect", false, "enum indicating effect of network policy change on one or more transport policies")
            .arrayField("details", "NetworkPolicyChangeImpactDetail", true, "if the above enum value is IMPACT then this optional object contains more details about the impacted transport policies");


        sb.resource("TransportPolicyRules", "GET", "/transportpolicies")
            .comment("API endpoint to get the transport policy rules defined in Athenz")
            .headerParam("If-None-Match", "matchingTag", "String", null, "Retrieved from the previous request, this timestamp specifies to the server to return any policies modified since this time")
            .output("ETag", "tag", "String", "The current latest modification timestamp is returned in this header")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("TransportPolicyValidationRequest", "POST", "/transportpolicy/validate")
            .comment("API to validate microsegmentation policies against network policies")
            .name("validateTransportPolicy")
            .input("transportPolicy", "TransportPolicyValidationRequest", "Struct representing microsegmentation policy entered by the user")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("TransportPolicyValidationResponseList", "GET", "/domain/{domainName}/transportpolicy/validationstatus")
            .comment("API to get transport policy validation response for transport policies of a domain")
            .name("getTransportPolicyValidationStatus")
            .pathParam("domainName", "DomainName", "name of the domain")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("Workloads", "GET", "/domain/{domainName}/service/{serviceName}/workloads")
            .name("getWorkloadsByService")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("serviceName", "EntityName", "name of the service")
            .headerParam("If-None-Match", "matchingTag", "String", null, "Retrieved from the previous request, this timestamp specifies to the server to return any workloads modified since this time")
            .output("ETag", "tag", "String", "The current latest modification timestamp is returned in this header")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("Workloads", "GET", "/workloads/{ip}")
            .name("getWorkloadsByIP")
            .pathParam("ip", "String", "ip address to query")
            .headerParam("If-None-Match", "matchingTag", "String", null, "Retrieved from the previous request, this timestamp specifies to the server to return any workloads modified since this time")
            .output("ETag", "tag", "String", "The current latest modification timestamp is returned in this header")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("WorkloadOptions", "PUT", "/domain/{domainName}/service/{serviceName}/workload/dynamic")
            .comment("Api to perform a dynamic workload PUT operation for a domain and service Workload details are obtained from the service certificate")
            .name("putDynamicWorkload")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("serviceName", "EntityName", "name of the service")
            .input("options", "WorkloadOptions", "metadata about the dynamic workload")
            .auth("", "", true)
            .expected("NO_CONTENT")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("StaticWorkload", "PUT", "/domain/{domainName}/service/{serviceName}/workload/static")
            .comment("Api to perform a static workload PUT operation for a domain and service")
            .name("putStaticWorkload")
            .pathParam("domainName", "DomainName", "name of the domain")
            .pathParam("serviceName", "EntityName", "name of the service")
            .input("staticWorkload", "StaticWorkload", "Struct representing static workload entered by the user")
            .auth("update", "{domainName}:service.{serviceName}")
            .expected("NO_CONTENT")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;

        sb.resource("NetworkPolicyChangeImpactRequest", "POST", "/transportpolicy/evaluatenetworkpolicychange")
            .comment("API to evaluate network policies change impact on transport policies")
            .name("evaluateNetworkPolicyChange")
            .input("detail", "NetworkPolicyChangeImpactRequest", "Struct representing a network policy present in the system")
            .auth("", "", true)
            .expected("OK")
            .exception("BAD_REQUEST", "ResourceError", "")

            .exception("FORBIDDEN", "ResourceError", "")

            .exception("NOT_FOUND", "ResourceError", "")

            .exception("TOO_MANY_REQUESTS", "ResourceError", "")

            .exception("UNAUTHORIZED", "ResourceError", "")
;


        return sb.build();
    }

}
