//
// This file generated by rdl 1.5.2. Do not modify!
//
package com.yahoo.athenz.zts;

import com.yahoo.rdl.*;
import javax.ws.rs.client.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.net.ssl.HostnameVerifier;

public class ZTSRDLGeneratedClient {
    Client client;
    WebTarget base;
    String credsHeader;
    String credsToken;

    public ZTSRDLGeneratedClient(String url) {
        client = ClientBuilder.newClient();
        base = client.target(url);
    }

    public ZTSRDLGeneratedClient(String url, HostnameVerifier hostnameVerifier) {
        client = ClientBuilder.newBuilder()
            .hostnameVerifier(hostnameVerifier)
            .build();
        base = client.target(url);
    }

    public ZTSRDLGeneratedClient(String url, Client rsClient) {
        client = rsClient;
        base = client.target(url);
    }
    
    public void close() {
        client.close();
    }

    public ZTSRDLGeneratedClient setProperty(String name, Object value) {
        client = client.property(name, value);
        base = client.target(base.getUri().toString());
        return this;
    }

    public ZTSRDLGeneratedClient addCredentials(String header, String token) {
        credsHeader = header;
        credsToken = token;
        return this;
    }

    public ResourceAccess getResourceAccess(String action, String resource, String domain, String checkPrincipal) {
        WebTarget target = base.path("/access/{action}/{resource}")
            .resolveTemplate("action", action)
            .resolveTemplate("resource", resource);
        if (domain != null) {
            target = target.queryParam("domain", domain);
        }
        if (checkPrincipal != null) {
            target = target.queryParam("principal", checkPrincipal);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(ResourceAccess.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public ResourceAccess getResourceAccessExt(String action, String resource, String domain, String checkPrincipal) {
        WebTarget target = base.path("/access/{action}")
            .resolveTemplate("action", action);
        if (resource != null) {
            target = target.queryParam("resource", resource);
        }
        if (domain != null) {
            target = target.queryParam("domain", domain);
        }
        if (checkPrincipal != null) {
            target = target.queryParam("principal", checkPrincipal);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(ResourceAccess.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public ServiceIdentity getServiceIdentity(String domainName, String serviceName) {
        WebTarget target = base.path("/domain/{domainName}/service/{serviceName}")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("serviceName", serviceName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(ServiceIdentity.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public ServiceIdentityList getServiceIdentityList(String domainName) {
        WebTarget target = base.path("/domain/{domainName}/service")
            .resolveTemplate("domainName", domainName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(ServiceIdentityList.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public PublicKeyEntry getPublicKeyEntry(String domainName, String serviceName, String keyId) {
        WebTarget target = base.path("/domain/{domainName}/service/{serviceName}/publickey/{keyId}")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("serviceName", serviceName)
            .resolveTemplate("keyId", keyId);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(PublicKeyEntry.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public HostServices getHostServices(String host) {
        WebTarget target = base.path("/host/{host}/services")
            .resolveTemplate("host", host);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(HostServices.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public DomainSignedPolicyData getDomainSignedPolicyData(String domainName, String matchingTag, java.util.Map<String, java.util.List<String>> headers) {
        WebTarget target = base.path("/domain/{domainName}/signed_policy_data")
            .resolveTemplate("domainName", domainName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        if (matchingTag != null) {
            invocationBuilder = invocationBuilder.header("If-None-Match", matchingTag);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
        case 304:
            if (headers != null) {
                headers.put("tag", java.util.Arrays.asList((String) response.getHeaders().getFirst("ETag")));
            }
            if (code == 304) {
                return null;
            }
            return response.readEntity(DomainSignedPolicyData.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public JWSPolicyData postSignedPolicyRequest(String domainName, SignedPolicyRequest request, String matchingTag, java.util.Map<String, java.util.List<String>> headers) {
        WebTarget target = base.path("/domain/{domainName}/policy/signed")
            .resolveTemplate("domainName", domainName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        if (matchingTag != null) {
            invocationBuilder = invocationBuilder.header("If-None-Match", matchingTag);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(request, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
        case 304:
            if (headers != null) {
                headers.put("tag", java.util.Arrays.asList((String) response.getHeaders().getFirst("ETag")));
            }
            if (code == 304) {
                return null;
            }
            return response.readEntity(JWSPolicyData.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public RoleToken getRoleToken(String domainName, String role, Integer minExpiryTime, Integer maxExpiryTime, String proxyForPrincipal) {
        WebTarget target = base.path("/domain/{domainName}/token")
            .resolveTemplate("domainName", domainName);
        if (role != null) {
            target = target.queryParam("role", role);
        }
        if (minExpiryTime != null) {
            target = target.queryParam("minExpiryTime", minExpiryTime);
        }
        if (maxExpiryTime != null) {
            target = target.queryParam("maxExpiryTime", maxExpiryTime);
        }
        if (proxyForPrincipal != null) {
            target = target.queryParam("proxyForPrincipal", proxyForPrincipal);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(RoleToken.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public RoleToken postRoleCertificateRequest(String domainName, String roleName, RoleCertificateRequest req) {
        WebTarget target = base.path("/domain/{domainName}/role/{roleName}/token")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("roleName", roleName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(req, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(RoleToken.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Access getAccess(String domainName, String roleName, String principal) {
        WebTarget target = base.path("/access/domain/{domainName}/role/{roleName}/principal/{principal}")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("roleName", roleName)
            .resolveTemplate("principal", principal);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Access.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public RoleAccess getRoleAccess(String domainName, String principal) {
        WebTarget target = base.path("/access/domain/{domainName}/principal/{principal}")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("principal", principal);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(RoleAccess.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public TenantDomains getTenantDomains(String providerDomainName, String userName, String roleName, String serviceName) {
        WebTarget target = base.path("/providerdomain/{providerDomainName}/user/{userName}")
            .resolveTemplate("providerDomainName", providerDomainName)
            .resolveTemplate("userName", userName);
        if (roleName != null) {
            target = target.queryParam("roleName", roleName);
        }
        if (serviceName != null) {
            target = target.queryParam("serviceName", serviceName);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(TenantDomains.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Identity postInstanceRefreshRequest(String domain, String service, InstanceRefreshRequest req) {
        WebTarget target = base.path("/instance/{domain}/{service}/refresh")
            .resolveTemplate("domain", domain)
            .resolveTemplate("service", service);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(req, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Identity.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public AWSTemporaryCredentials getAWSTemporaryCredentials(String domainName, String role, Integer durationSeconds, String externalId) {
        WebTarget target = base.path("/domain/{domainName}/role/{role}/creds")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("role", role);
        if (durationSeconds != null) {
            target = target.queryParam("durationSeconds", durationSeconds);
        }
        if (externalId != null) {
            target = target.queryParam("externalId", externalId);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(AWSTemporaryCredentials.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public InstanceIdentity postInstanceRegisterInformation(InstanceRegisterInformation info, java.util.Map<String, java.util.List<String>> headers) {
        WebTarget target = base.path("/instance");
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(info, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 201:
            if (headers != null) {
                headers.put("location", java.util.Arrays.asList((String) response.getHeaders().getFirst("Location")));
            }
            return response.readEntity(InstanceIdentity.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public InstanceIdentity postInstanceRefreshInformation(String provider, String domain, String service, String instanceId, InstanceRefreshInformation info) {
        WebTarget target = base.path("/instance/{provider}/{domain}/{service}/{instanceId}")
            .resolveTemplate("provider", provider)
            .resolveTemplate("domain", domain)
            .resolveTemplate("service", service)
            .resolveTemplate("instanceId", instanceId);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(info, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(InstanceIdentity.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public InstanceRegisterToken getInstanceRegisterToken(String provider, String domain, String service, String instanceId) {
        WebTarget target = base.path("/instance/{provider}/{domain}/{service}/{instanceId}/token")
            .resolveTemplate("provider", provider)
            .resolveTemplate("domain", domain)
            .resolveTemplate("service", service)
            .resolveTemplate("instanceId", instanceId);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(InstanceRegisterToken.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public InstanceIdentity deleteInstanceIdentity(String provider, String domain, String service, String instanceId) {
        WebTarget target = base.path("/instance/{provider}/{domain}/{service}/{instanceId}")
            .resolveTemplate("provider", provider)
            .resolveTemplate("domain", domain)
            .resolveTemplate("service", service)
            .resolveTemplate("instanceId", instanceId);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.delete();
        int code = response.getStatus();
        switch (code) {
        case 204:
            return null;
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public CertificateAuthorityBundle getCertificateAuthorityBundle(String name) {
        WebTarget target = base.path("/cacerts/{name}")
            .resolveTemplate("name", name);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(CertificateAuthorityBundle.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Status getStatus() {
        WebTarget target = base.path("/status");
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Status.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public SSHCertificates postSSHCertRequest(SSHCertRequest certRequest) {
        WebTarget target = base.path("/sshcert");
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(certRequest, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 201:
            return response.readEntity(SSHCertificates.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public OpenIDConfig getOpenIDConfig() {
        WebTarget target = base.path("/.well-known/openid-configuration");
        Invocation.Builder invocationBuilder = target.request("application/json");
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(OpenIDConfig.class);
        default:
            throw new ResourceException(code, response.readEntity(Object.class));
        }

    }

    public JWKList getJWKList(Boolean rfc) {
        WebTarget target = base.path("/oauth2/keys");
        if (rfc != null) {
            target = target.queryParam("rfc", rfc);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(JWKList.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public AccessTokenResponse postAccessTokenRequest(String request) {
        WebTarget target = base.path("/oauth2/token");
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(request, "application/x-www-form-urlencoded"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(AccessTokenResponse.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public OIDCResponse getOIDCResponse(String responseType, String clientId, String redirectUri, String scope, String state, String nonce, String keyType, java.util.Map<String, java.util.List<String>> headers) {
        WebTarget target = base.path("/oauth2/auth");
        if (responseType != null) {
            target = target.queryParam("response_type", responseType);
        }
        if (clientId != null) {
            target = target.queryParam("client_id", clientId);
        }
        if (redirectUri != null) {
            target = target.queryParam("redirect_uri", redirectUri);
        }
        if (scope != null) {
            target = target.queryParam("scope", scope);
        }
        if (state != null) {
            target = target.queryParam("state", state);
        }
        if (nonce != null) {
            target = target.queryParam("nonce", nonce);
        }
        if (keyType != null) {
            target = target.queryParam("keyType", keyType);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 302:
            if (headers != null) {
                headers.put("location", java.util.Arrays.asList((String) response.getHeaders().getFirst("Location")));
            }
            return response.readEntity(OIDCResponse.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public RoleCertificate postRoleCertificateRequestExt(RoleCertificateRequest req) {
        WebTarget target = base.path("/rolecert");
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.post(javax.ws.rs.client.Entity.entity(req, "application/json"));
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(RoleCertificate.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public RoleAccess getRolesRequireRoleCert(String principal) {
        WebTarget target = base.path("/role/cert");
        if (principal != null) {
            target = target.queryParam("principal", principal);
        }
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(RoleAccess.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Workloads getWorkloadsByService(String domainName, String serviceName) {
        WebTarget target = base.path("/domain/{domainName}/service/{serviceName}/workloads")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("serviceName", serviceName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Workloads.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public Workloads getWorkloadsByIP(String ip) {
        WebTarget target = base.path("/workloads/{ip}")
            .resolveTemplate("ip", ip);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(Workloads.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

    public TransportRules getTransportRules(String domainName, String serviceName) {
        WebTarget target = base.path("/domain/{domainName}/service/{serviceName}/transportRules")
            .resolveTemplate("domainName", domainName)
            .resolveTemplate("serviceName", serviceName);
        Invocation.Builder invocationBuilder = target.request("application/json");
        if (credsHeader != null) {
            invocationBuilder = credsHeader.startsWith("Cookie.") ? invocationBuilder.cookie(credsHeader.substring(7),
                credsToken) : invocationBuilder.header(credsHeader, credsToken);
        }
        Response response = invocationBuilder.get();
        int code = response.getStatus();
        switch (code) {
        case 200:
            return response.readEntity(TransportRules.class);
        default:
            throw new ResourceException(code, response.readEntity(ResourceError.class));
        }

    }

}
