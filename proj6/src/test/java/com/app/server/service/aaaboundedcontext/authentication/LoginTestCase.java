package com.app.server.service.aaaboundedcontext.authentication;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setNativeLastName("se91ywN6UiIjK7kwZNl6ZFjRF3kE3laHx1huNYLV2tmqJ913KN");
            corecontacts.setLastName("4u5tHbjoc4t4yJbb9MDTgMnoCoX2f5qDk8DYZ7hgTMArfLFS1k");
            Timezone timezone = new Timezone();
            timezone.setUtcdifference(9);
            timezone.setCities("dL5wbK475bkCA10wBW5aGOgGdYeO3nH6YCXcdVr5eRqVWKskrc");
            timezone.setCountry("AznZklaeJbgexy5tG618NBDb9lRLSP8w48dn3SivxPGNKw8XwE");
            timezone.setGmtLabel("Ro4y2bAgLaXwC8uCJBdBBIsyVFeQtxC9wJQvjeugdr9ReDDNzF");
            timezone.setTimeZoneLabel("kzGpZsu3UoCAXl0xJRfZshHuUFNs1STrWBy6sEQ7Q6AYYplBxv");
            Language language = new Language();
            language.setLanguageIcon("V4eXruUJnYbF2KNYTXVi39qV1PKKNFuPJmnpesZCVPhUTM1b9N");
            language.setLanguageDescription("7LbLobupSmwX0QgrRdXhFPFeKrqDyxrlV6dlSNyL1JCl1vJ41X");
            language.setAlpha3("mX2");
            language.setAlpha4parentid(1);
            language.setAlpha2("Dd");
            language.setLanguage("82KRglVsE7gTeUYlj60um71kWfZTewqnp0ZP9wxceVk9xq5RHg");
            language.setAlpha4("5uEj");
            language.setLanguageType("RR0sXBcNBlwVrosKESGGCk4wnVoa803R");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Gender gender = new Gender();
            gender.setGender("uVevAmsTfIiUznjpuhvm6WfxnnjCE0aF4oiJLiv2vEf9T9WVNW");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Title title = new Title();
            title.setTitles("tabfip82jVgRd0EzxWBDWv3QMfeIrRRbzUfgqXxPC65Uxho6CT");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setNativeLastName("pfAdfSElWCji9fKykKVSN1G2wizOV3KU1we3P8vDuBRGPXNe2n");
            corecontacts.setLastName("DVvgeCftaoHxemvobDIeZSlBOwX10sbpoKvPewIa1COBupzSPQ");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setDateofbirth(new java.sql.Timestamp(1457949055708l));
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeTitle("mHyn2ykfZBwq26wPxOFmRTgkAOrvBXgac1njErG4iStBk2Rq0B");
            corecontacts.setNativeFirstName("VdPImVbRPv4fvAORyTtWW7HBygsNnv4wrsG3fL9s5rVOs07OnU");
            corecontacts.setFirstName("XFpjIBI6RXkXTJYZGPLXR5rX89CQlOT5aZbkyqjQJCgxYF4RLA");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setPhoneNumber("b6amByPD8wlVXWuQolom");
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeMiddleName("Qt5xLiwHoLG5dm2DzhahaMT0fW0idGarR7bqGso39BozUGULDQ");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1457949055864l));
            corecontacts.setMiddleName("CTIqzwqpoxudTLg7B7TRsz3qpfykiEywnM0fmSIuuj5cdoPFYh");
            corecontacts.setEmailId("6M3jywO4rtujEYJhX2mCFFNQLl6WgtyWpAt2zzsNnABG3e2zdR");
            corecontacts.setAge(116);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            State state = new State();
            state.setStateCodeChar2("3NEAXadHIn3abe8OmKUxOiSgXpSNECPz");
            state.setStateCodeChar3("Fk5RvGRwLEr3Sj4FKF52nB4o1hh6ROcG");
            state.setStateName("mraHkz8Xc9Ygr13eKWZ0TvjTenptSaAirWEqj2RHhpIgiKNvog");
            state.setStateCode(1);
            state.setStateFlag("6DhVzYQrIpN9g2mwbLXvyJIsMzrlbLs3SUgIkqHBE69Azg1vva");
            state.setStateCapitalLatitude(3);
            Country country = new Country();
            country.setCapital("LvoLt8gXK71osaONX1GYwYvKZMB8ld9B");
            country.setCapitalLongitude(5);
            country.setCapitalLatitude(4);
            country.setCurrencyName("Da3jUv9DblXx5fvtm1rqh797pjn76Z58gxOQUwwJnRxErW3PhZ");
            country.setCountryCode2("YTS");
            country.setCurrencySymbol("C91C8jftEOJyB5GNK8TiT9dzRfat3DR5");
            country.setCurrencyCode("Jub");
            country.setCountryCode1("FCZ");
            country.setCountryName("6ThbaQJFN5ijsvlTUHcePAZQ2JPLjCG7YEsm2k1LricEr4fmrl");
            country.setIsoNumeric(5);
            country.setCountryFlag("n89WsTpRcySZMOpNNlBHnAFVoy8z1MAF9w7mth6M1GXmqA9U8P");
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            state.setStateCodeChar2("Eo82bSWWHuqMKpZoN2wtGLRDFDz40PLv");
            state.setStateCodeChar3("plAtnalV0YjJA10VtfReCIFokYHyFfBx");
            state.setStateName("QcOpsFbt94NA7wjWZIR7vd9YdLEcPSzMZZdBgjkqn04exH2FoC");
            state.setStateCode(2);
            state.setStateFlag("KS047jYPgxmscjUh2I1YZgTlq9NdS4O5DEr5oze8CjMB0Oz8jb");
            state.setStateCapitalLatitude(9);
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapitalLongitude(2);
            state.setStateDescription("6zlILyfTftUB7pJfUmymqvxkDBxaCyFBBpg7yuYGl7s8ygY3eo");
            state.setStateCapital("lyxkYIgbLWkdUoGSlBAQIyizLbi82xYmxgiwNPie7CgriNC3aM");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCodeChar2("9bNrAkTUcLnLNBO91meWBHjZhoie5yXc");
            city.setCityName("L0HKZb4mZ1cQjwsPo1UJ2t3k655tAgIJBFx2MYfiAgybyX5Jrl");
            city.setCityLongitude(5);
            city.setCityFlag("iDwQ6Q7E66Kb73tpNCd08Qt69cuuqucu9IWizKHfd7BlJwneu0");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setCityCode(3);
            city.setCityDescription("I2cjNDddC685KohnrES7Gcou9YyPsREU2QUyIqr8o8XRQgQjXU");
            city.setCityLatitude(9);
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            AddressType addresstype = new AddressType();
            addresstype.setAddressTypeIcon("vDLRBIKj7GrymIyqEnvNLtUwjDHE3uWrjPCjIbM8vMVHNvImFN");
            addresstype.setAddressType("6j4aKDGznW1wHlr1linDaqAazo1A9kRakevItHyzKFXFoLII7w");
            addresstype.setAddressTypeDesc("ZoC4BHpjzWpzjuvJgwaRulzYZUpzS6rYHg5tA2iLK1sv09opYw");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress1("0LbrWS4wvcdamihGxWanuiAwf5SKbXsS27pQAWoMa9CYXqlILv");
            address.setZipcode("JdLJzy");
            address.setAddress3("Ft1tHiN1dRDmOiXjLihsJ4HjFsFWcBRhR7th27XGYHcrPCDfr0");
            address.setAddressLabel("31T3VpZZVnS");
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setAddress2("empqorJOcQSpzUcxASoGFnsfyhkvIMLdsuISnfnWu4xlnQeBTP");
            address.setLongitude("vjFYH0sshnhWMI8qQGHPKOcThxVMuc0WB1Iibxa3I6WFHPnVvd");
            address.setLatitude("nD33Sg4BnetHtAlxmIjm91vuq1nL8ACfbyku07OTfCvhN0fpJQ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            CommunicationType communicationtype = new CommunicationType();
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupName("JvTPYoQhdE6JuADsIrTvXkG7HMCDGtfU6yW7QqalGupfW3KvEf");
            communicationgroup.setCommGroupDescription("HWrF2bQ2PiOi8X0Mwo8MJZmZ2GjIsDh1aR4kJKwXTBAVzjHoYg");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeName("dKzTOrNkCU9fND3cQXhO1f5D6UO9BbjcDpIJgA1UAJtPsDBLLT");
            communicationtype.setCommTypeDescription("PB7CYEK1h3wftZCA1hsE84wVkjrolpUVb6VskQ8j5zFT7fE4eC");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommData("5");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setIsLocked(1);
            user.setAllowMultipleLogin(1);
            user.setIsDeleted(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainName("98ZfnJyAMPObE6DVtZjHQeR96WVWvbZb9TwTKUWDE8XoDi7xp1");
            useraccessdomain.setDomainIcon("Zo0LrBweFY4QgEqvZh31ybASNEBrGXktUNPMVDxgPWDVjbPDVo");
            useraccessdomain.setDomainDescription("NoPWA70GzuC0u2BJGBZKQqxXmXOMmpEQ23asRlE3JpI4her8xJ");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            useraccessdomain.setDomainHelp("VH0AviS0erWa7k8HSxpvQmLQX3yTsjuQvKh0HYnyw8zHpHEImm");
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            useraccesslevel.setLevelIcon("9zPvExZKpFizcOlZngQOttGiQj9z3sXx7XcU5U4fhpzFshXKuZ");
            useraccesslevel.setLevelHelp("nSrDmeZReXmRkWNiVIRF54t834XbUTvnDWwN9FrX4G9TM4h3kw");
            useraccesslevel.setLevelDescription("eByeRukmuoQVuHMJx24RTmP050xfgwADtG63KDTT6ybdG0urdY");
            useraccesslevel.setLevelName("VCZRNmGb4aStGobnLtBiOeOMAhb3qCAYC2eUPFGmw9kMEhfx9h");
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setIsLocked(1);
            user.setAllowMultipleLogin(1);
            user.setIsDeleted(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setGenTempOneTimePassword(1);
            user.setMultiFactorAuthEnabled(1);
            user.setChangePasswordNextLogin(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(1457949056341l));
            user.setUserAccessCode(56358);
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setPasswordAlgo("GxCUXmr5mpGuWzieDcH1AX22JU8lf3Nnr9uc2U6PtklWQJFLEP");
            user.setPasswordExpiryDate(new java.sql.Timestamp(1457949056372l));
            user.setSessionTimeout(1137);
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            Question question = new Question();
            question.setQuestionIcon("D204dRTEwwtj9zSoLxo0a06ou6RoToQDSPHumlj5n8mMPSl4oI");
            question.setLevelid(4);
            question.setQuestionDetails("4");
            question.setQuestion("KYgDDFXtG9I5o9pqPvmSjNnS3zezlgWnapBwOBFL7FDwyYYYiY");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setUser(user);
            passrecovery.setAnswer("CnMa5NDA25qp3zy98PB7N7KVwJcj7c1WRSQXkE00UVkwUphdV7");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457949056535l));
            userdata.setPassword("p8vDSn6ofpWsplCWoz3iHKIfv4MeLgIZYmfXyGytQ9h09nYqFE");
            userdata.setLast5Passwords("eNz2vbSIt80J88evc7Tp9yLAziO9Ejkg2gIDLAvGN1QGWxo8zS");
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1457949056553l));
            userdata.setPassword("SAh2fQVvlFZDYI7p4HwukyLNGAn2Y14y7c7LF899qC5MNbGn7e");
            userdata.setLast5Passwords("aLWPm4OFC1saeNnOp67FOQJd9RKVzckYzCikOBeuBxxt4kuAGn");
            userdata.setUser(user);
            userdata.setOneTimePasswordExpiry(7);
            userdata.setOneTimePassword("IlFv3et6cO97fHnXJVEfTHAYlE0ElcM5");
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            user.setUserId(null);
            login.setUser(user);
            login.setIsAuthenticated(true);
            login.setServerAuthImage("L5oCbhBAtJnuPqN3AH9hASd7PnnH1jTS");
            login.setFailedLoginAttempts(11);
            login.setServerAuthText("V5iKnbgTG93kMjRg");
            login.setLoginId("3drELoedqTqLCMCMDpSO20Cs4Mux6aUmj998jxkwsUGHAS61FY");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthImage("e5gC1lAP7gVosXZ1OhoYHZozbHSSixeP");
            login.setFailedLoginAttempts(2);
            login.setServerAuthText("hT3yZc1msqsYnhIq");
            login.setVersionId(1);
            login.setLoginId("ugfE01MN6HErF2ghyGUZutWnUw5ky65POd6zHisoi4r3cCrY4X");
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
