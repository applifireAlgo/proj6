package com.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.City;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            State state = new State();
            state.setStateCodeChar2("YY9IE242r57ZoTIgw9GlHEruBWqAkJ0A");
            state.setStateCodeChar3("VaQVWIpp1feesXa7g1zEv7uncA2RgLOw");
            state.setStateName("mVxom1aVm9etqGpPskBVIGgjEJUx96vFV9UwS5fK9wmP2ZdXws");
            state.setStateCode(2);
            state.setStateFlag("QwZZsptGQ05aIqFB87aAvZ6yRKgoXEHQBaIqvkyma6pWkv1326");
            state.setStateCapitalLatitude(6);
            Country country = new Country();
            country.setCapital("6zyZYkhqUn8wnm0CqGD3lrnABZuNwqHb");
            country.setCapitalLongitude(1);
            country.setCapitalLatitude(5);
            country.setCurrencyName("U15925Iyi35fhJ5siUYaXvmCpNQmY9nyQuSgHFpH4Fp7BEW2Zs");
            country.setCountryCode2("eUD");
            country.setCurrencySymbol("jjHx5z54gyYbyVCCZeI8XasiryejWY9e");
            country.setCurrencyCode("wvF");
            country.setCountryCode1("fLn");
            country.setCountryName("Cz6pU11P36xa3cvK4wUJsN9e1Sf8TXqofaO3rnq7CffutN4Lpe");
            country.setIsoNumeric(4);
            country.setCountryFlag("tcLuoMxnYVSQ6ejd5CUfQADXaKLf6C1Be2LCWQFQzDn0tmArxH");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar2("IhB2IX3MpAevC1NvB51VQ4lhK6RvHBbf");
            state.setStateCodeChar3("ZNT0VkABtgAVpNPGMjkaTfuBguhJuuf0");
            state.setStateName("PWS5fkMpAGQTPsbS1iUx3IZ0PhByyzAqfursOdvs7OVMQuzJBh");
            state.setStateCode(1);
            state.setStateFlag("SRDpCmsQ0BHoKRcKNgb9FYNbLl1CNGUrcVv1dj36FVmvm2CtIW");
            state.setStateCapitalLatitude(9);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLongitude(5);
            state.setStateDescription("SZrKrjr7mIm5tJM98LkZ4QTu61Cw73k1b93qgzcJH2MaMbo87P");
            state.setStateCapital("B12HbtMfrgMyFKINzh5r6r1BAk81xeNaE2kqhLHcktZf0Hxy5F");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("wR0CJ5Jdm47O3XMXSSxIw4NhHt2nR6eD");
            city.setCityName("P6GNSs0LkUWQ0wyiC2oJbWkNKeqH0eqmE0orxJjBk5W18LRWYH");
            city.setCityLongitude(5);
            city.setCityFlag("V9dUhNh1APHzV5KG7wDkYVZIqZL6xVyuKEo45ZF1da5Aeww5MR");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            city.setCityCode(1);
            city.setCityDescription("XDmlTrZh8tcPurKtiPUm4tja1bhfkcZVtQz05JQkHz7kIlWRA0");
            city.setCityLatitude(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityCodeChar2("Kxp6h2mWFf0VSSTLUonOO6uEmc27oI3h");
            city.setCityName("yCV8rzLG7YPfyciF1XbSrBKuHSkwGRMv0JOswD3oGMk8sSUcm5");
            city.setCityLongitude(7);
            city.setCityFlag("Vq3Nv3XdM1vLGQMqEgZgVJF7pUnU4QswTs46MtOHEiO9Q80Dd6");
            city.setVersionId(1);
            city.setCityCode(2);
            city.setCityDescription("w04ItljWHiL1EXpJ5IdZW93IVEdXIszIoNPFsATzYSL2SN15D3");
            city.setCityLatitude(4);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
