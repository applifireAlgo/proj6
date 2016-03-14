package com.app.server.service.organizationboundedcontext.location;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.Address;
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
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            state.setStateCodeChar2("xYKcOSx9xHVgE6iaSlTd6Jm8ltKbWzpR");
            state.setStateCodeChar3("KE0HBzAl519vb1Udw7DcCmNGOO4od3MD");
            state.setStateName("UbrIZHeNkVTxGe5Sda7S5zARCRF0brmMs7kEPSPxm0EcZdYNhe");
            state.setStateCode(1);
            state.setStateFlag("p0mE7rrynczFg7GbgCK6tN0HxD5WzL8KHJZBsKdkOvUfikL4pg");
            state.setStateCapitalLatitude(7);
            Country country = new Country();
            country.setCapital("0XiCnru9sCf7ULuLk0ZZikCrHcteJ4Uy");
            country.setCapitalLongitude(5);
            country.setCapitalLatitude(9);
            country.setCurrencyName("dzeUIyzbpb4AFHz3Npu3Cnlu2HHukXMHYSsdlaKIPPaP3NQPa6");
            country.setCountryCode2("URY");
            country.setCurrencySymbol("B8m2KPz5vG362LMGCk7E9B93rxxFwWkB");
            country.setCurrencyCode("fRU");
            country.setCountryCode1("4zb");
            country.setCountryName("L76LHEArX8u46zDKFcPndcYFyzZk07Rb8yuJli5NcfABJ47wps");
            country.setIsoNumeric(4);
            country.setCountryFlag("vB2b4TU2dCMJZn4rcknof5ZFY3pLT0LopwhYbIH5CAXyvDobcE");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar2("87T6m5gTyZqc7CTQ3PELQlynHIEzJiBu");
            state.setStateCodeChar3("ZGVzdpLUoFm25Cn1Y4FArhkv3Xnm94xh");
            state.setStateName("aB5fVhl1a5ZSKdnuB0ryoPoMlyE7jQImTcqoxsfdYXQwceCyTx");
            state.setStateCode(1);
            state.setStateFlag("Z3qSFKxc90T8CSsd0zNJDxE0uw59RyhzGrrieIyVIjxXksckRZ");
            state.setStateCapitalLatitude(3);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLongitude(7);
            state.setStateDescription("2sMhz7kDM2I3gAMhSX6jxZlO10jxxvo5UwVszDPfALhheZGrtU");
            state.setStateCapital("aNlfiO4LCe6cUqBB6xOoX7HG88XZZTSn4EAWovPv04xdSZbwcE");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("7hPs4DCs3pZ1c5Z3bppT8obutCXSitwY");
            city.setCityName("Mgg5iu8OO9HsC4qJEwyU57zxT5IxeCMhbFOEIRmRWHCk8HAxS3");
            city.setCityLongitude(10);
            city.setCityFlag("7Ny45tGMACBlS8qN1ARSnXN9OSjumLjHoj4NgpidGDTERe0MGG");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityDescription("t9Kr1clZgc3LWzRCkd821uURh872ltwFr6XaC2VxIzLM0mjR7c");
            city.setCityLatitude(2);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("VAGO1lZBHmi5YjsymqePfW0iJejeVWc7ux1lQCqgIGyPQK4TNe");
            addresstype.setAddressType("ycaVBt4bbv5VmFdQBmoXVComWvnQ8dRKciXtx89HOHqpAgC29q");
            addresstype.setAddressTypeDesc("LX8OBot1bWnmRKRDG1LeIffQeqHxgW8EVTtyb1hrCwyhMBNIFM");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            Address address = new Address();
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("2OSSMR54nrq07euWbqbXiapy7X2mqLM4m6SlbijOKTNfZupLeP");
            address.setZipcode("Y5lkL5");
            address.setAddress3("FU84ktviDMzUUFsrWEvglfJhU0NhJXnBpK9cNi4CvNWzMyMOby");
            address.setAddressLabel("KYIQoKiOdL8");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("TX75VZLrGC4ELb6JB42F77ajmAnj2kvgmg5dmfYnCFhXZFrwmh");
            address.setLongitude("L0c8JIlxsMjINYxdaK3gd4QuCUF2eRUb96zyuOkjSYNMFK4GP7");
            address.setLatitude("C91OIjv522rFi2kpyaRoH1VauvsWETFjiNvUp2aJhG3uYjqZFV");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey());
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
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

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setVersionId(1);
            address.setAddress1("Awhx8wQQu9uKz2giAkNpEtnoKbrB0LCm6qJTYKS4JcFB44AxwJ");
            address.setZipcode("cIfs4I");
            address.setAddress3("fke8tcbUPgrFsMj2wusnjaobKTh9XQ0pZ7qgPwgVQDq3Wg45xw");
            address.setAddressLabel("IOnoCuhO3Lu");
            address.setAddress2("3gRrZftEXcybtI0Elz6nzal2d9H5GhMosCqGIOD8Bv2FgIYevl");
            address.setLongitude("RDqj8yyv3I28LGT4AodNrxK8Pt2FtXwzLI8mKI1ploT7uqrC3v");
            address.setLatitude("1FXaTmiPoI5ubRd6d6mGYDuuCfbPEPQjiNHwYROk97WfgPwNfM");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
