package com.app.server.service.organizationboundedcontext.contacts;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Timezone timezone = new Timezone();
            timezone.setUtcdifference(8);
            timezone.setCities("WQPDm3BmXmk6UiUv6i0oPwUAj52tshW46HZqBnCPaFjDGJXOTp");
            timezone.setCountry("3rfM2viie2M59TMFmw9gGlGHf46YTDnIHTipwgcMcALq8K7lIy");
            timezone.setGmtLabel("Y6cEypsiolkspGi5QTcrM8kHQVuERdOdieHlbmew97Z4ICTn9k");
            timezone.setTimeZoneLabel("BAdP9WZQqARI74sOGBuEbd1ytWjEaqWTKQsy8e69zuQiI0Km7o");
            Language language = new Language();
            language.setLanguageIcon("nKtdoT8Y2WddT1Aju7nmF5n1qo0OWvGFtbucURoJA1a7HqoWw4");
            language.setLanguageDescription("FBKxmbjRDu6krbP7af1NnJ2YxXdD3Xwdx2rPMYWpx1SZVkpKNk");
            language.setAlpha3("SoP");
            language.setAlpha4parentid(6);
            language.setAlpha2("Yw");
            language.setLanguage("3coAmouREHSRHWYpjXnbMRxNJsiBrBW1L79alJCqlwK4GlaDjS");
            language.setAlpha4("RfUI");
            language.setLanguageType("qu12q4oa7JnaHVHkR0NHNW5gGzjFTFDk");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("m8EpIE4hjtZpd4xmPA2iKEOXnqiGC1bvwWOISKjGNEMEe4zIwJ");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Title title = new Title();
            title.setTitles("LXNyTc0SplV9NEyFJ7r11J4gHxEcRYsaTVojyryhEfge9v6sDA");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setNativeLastName("47i7SDaAwcK5bM6NCMHXCgFuN5n7yAlPGWzt60WiAcgSKSfWmu");
            corecontacts.setLastName("X3X40Ey2HQdqcvBWQXhYl0EjduCgYOcxRvtLWWqbc3l7n4rC7z");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457949047563l));
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeTitle("MeypCpFMjlhQzhG0KSu8IJ65RJA5SYffFgg8fs7aazbFFGN06s");
            corecontacts.setNativeFirstName("fIsNZYtuZKtnVpingHJpDnanEhV2rQf3h0JduZANpf5x2YDSL5");
            corecontacts.setFirstName("nJjUdWHZs3qnlCKjI72CZxwNVaCXax4DKU9h9GuuI82wwuL4fv");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setPhoneNumber("00eYdyO1XZ5GI9a0dpVe");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("pgyvnKMw3osQvCmx81tulpiHx6Vz1FhWLPQQcH3csQ9ggOBVql");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457949047713l));
            corecontacts.setMiddleName("kL1zIttKbp4XAR84qz2oRfZncCUgWWMJeQiogZYKs1DT551H9b");
            corecontacts.setEmailId("Wz5AodexwG8sYNJ2rdhY2ylyfbLML7zQ50kKKK2jWQzU38c4qo");
            corecontacts.setAge(37);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            State state = new State();
            state.setStateCodeChar2("zyPVS9jYx4iuVFdEVDqlqMU0cszg9cQz");
            state.setStateCodeChar3("z4rTUO3Xg84uqjU7h0Ee7hpqdRLIFrMH");
            state.setStateName("X5qqUkzwL2Ox4mcXxzCVE16exiv64UkOIRedAKSgF4JoGXm4bT");
            state.setStateCode(2);
            state.setStateFlag("YrZyN8nP3i9zxmyOEO0nlCf4VeiclpZMrPMAFlEGcI1QHbOL5L");
            state.setStateCapitalLatitude(10);
            Country country = new Country();
            country.setCapital("5dSQoKjshdcr7SMvLpahMZiQUwx5BtVy");
            country.setCapitalLongitude(7);
            country.setCapitalLatitude(3);
            country.setCurrencyName("WBvyIspkLFWMopOTLhIqbbFtcvMSPR2dSKiXKITMUzs9PDaLW6");
            country.setCountryCode2("H8J");
            country.setCurrencySymbol("459bj5A0tes9pt9QtJ41Xzs526kdvXTB");
            country.setCurrencyCode("KBJ");
            country.setCountryCode1("UYy");
            country.setCountryName("h7y4ezud4lDDXW1ezSKM6sxOum8uR9eMxQ3eD9j3qRRJgHqtG0");
            country.setIsoNumeric(7);
            country.setCountryFlag("2T1kN5tA3HIDId0yRoUMZhWRP1p40Q2ASS8JhMCQN4n4SXTf9r");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar2("ykAu1s6A64K7u9Y8P7rFZ2tKC5FwTaUU");
            state.setStateCodeChar3("4wGD0PauUH6j4NbeK6rATuw1IeTYqPoS");
            state.setStateName("cC1O4J28ewXxK2WKY4f1PEVMb1WyMoKmiEpYI9pq0mZIGAyOcd");
            state.setStateCode(1);
            state.setStateFlag("QbIjllh3nKYluRD56rSMLduFKvP9oZi5FgPqAWWbsDbkExogiS");
            state.setStateCapitalLatitude(8);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLongitude(7);
            state.setStateDescription("8Pi5XBn5rV7Kd4fvUaS3JqtTbNgLnFjo9lhydKLK53XZzj2NG7");
            state.setStateCapital("e4cy0YWlukCIyvoyOXg8dQgJkRr7dilbBDFJx5wvGIbyB4k0ZO");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("7Q3zcuDoRKuygs5b5PUjv7KfBJekr6ay");
            city.setCityName("XvYzrl4yZHOcntPrDS20jljKC8Tv11LMxFKSCNbn9aH7Pjh2vx");
            city.setCityLongitude(5);
            city.setCityFlag("XpoxdprrL4LOFXv8osFRGWMeRTiYPNlsFCCo5SyTobldLW3NbH");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(1);
            city.setCityDescription("XB6V7pazFwrBEG50mFpXxCefwRijsi3wMiAtxZ23D5ulu41hOI");
            city.setCityLatitude(1);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("nmHxZvRB7eT5FugRP7DflFDRMYwY4BTlwWyDHpUfzQ42wpdL2c");
            addresstype.setAddressType("N7FoV3smMcPp2yTAybvLSWdlah0qlpsMfFTYHfgWA3TQMkWTKG");
            addresstype.setAddressTypeDesc("pmwPLJDDo5M06CVfUgkF2qyxBFJR3hVz7gSG3PyvZzz6TEVMpa");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("KgyguIr2Rg3zb11yOxNeB1pp3lLqvoIJV1ST0lfuucnfhaM1Wd");
            address.setZipcode("hSyPTG");
            address.setAddress3("x73UoQYB2JUrvbQ7gbCUxFfwyx4rTQTbTuXUiJtKjAXvVSR3IQ");
            address.setAddressLabel("xyk9GrOzKeo");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("6shEqPSMm2zHWr5UgceKApmynJE53xvwTN8vTwuOwanPDwyVv5");
            address.setLongitude("QknaBRlCf5eLWXo6QDvmi37uAKI2QD9F6fHE1EqYgVb7xjFPEY");
            address.setLatitude("kzfCnXhftnAS7hHvafYw6cyrSpF1FsAzG5BNv2F9b5WvGiVB5m");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationType communicationtype = new CommunicationType();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("8OkndCZuQjAuBAe5IBecqHAWWBzJ8LvGHFGYElC8eUPfQkClPG");
            communicationgroup.setCommGroupDescription("HO9ac2zQcBA2juktKmvgGPH5w64iQwSR4hdaKHY7WXoksQyghS");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeName("bndqTorIuWV5XTWd4o33lAHMBGp3jpdxDS6DxzaXll00ErcREn");
            communicationtype.setCommTypeDescription("MqocaGz2kllhRG1bB77LxMWCfB9iWuhG4BfDuKPfJqboXjSyKt");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("P");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("mcc7pcK1mlkur8AjBvliABKla412pOHHYLVGFs7DPH1rtKRDOQ");
            corecontacts.setLastName("2qDQZ0tKFmX0bBuGMND4MjXwMV1dNw7QyBJVarPRhXZrU7wGcw");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457949048176l));
            corecontacts.setNativeTitle("Sz8hhlvNVJzlSZ6O3cbUjSW88iPN65STSMP8CcXtWcZlleCoFA");
            corecontacts.setNativeFirstName("UXChyIHuSvjsXbnXjexuZK59Sqxb59ub9QWjmGq8EjVQasXME3");
            corecontacts.setFirstName("mPP75EYzOQKWPgykEQ4HhezjkHuZfKqyF5QkwVbGWvUTR0Ixng");
            corecontacts.setPhoneNumber("Aqg9U3UPrNz2qMAQRJ6P");
            corecontacts.setNativeMiddleName("QxwrAE0kfHaDBhCrTemCIEDrO9HSrNQfB1QOYzApOcZAXiF5j2");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457949048261l));
            corecontacts.setMiddleName("O3iRsVgjrC7fUq1UCbvaBWkEsPxaDTpnwZha5dyNX06raD9nPY");
            corecontacts.setEmailId("U96uUrv9ft1CV0VquTrl2shLjXUnSgLFCvnI7qVw7g2GNIPuFk");
            corecontacts.setAge(60);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
