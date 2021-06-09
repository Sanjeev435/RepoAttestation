insert into t_admin_detail values(nextval('S_ADMIN_DETAIL'), 'I0217');	
commit;

insert into T_PROJECT_DETAIL values(nextval('S_PROJECT_DETAIL'), 'Test Sample 1', 'github.com/testSample1');
insert into T_PROJECT_DETAIL values(nextval('S_PROJECT_DETAIL'), 'Test Sample 2', 'github.com/testSample2');
insert into T_PROJECT_DETAIL values(nextval('S_PROJECT_DETAIL'), 'Test Sample 3', 'github.com/testSample3');
insert into T_PROJECT_DETAIL values(nextval('S_PROJECT_DETAIL'), 'Test Sample 4', 'github.com/testSample4');
insert into T_PROJECT_DETAIL values(nextval('S_PROJECT_DETAIL'), 'Test Sample 5', 'github.com/testSample5');
insert into T_PROJECT_DETAIL values(nextval('S_PROJECT_DETAIL'), 'Test Sample 6', 'github.com/testSample6');
commit;

insert into T_ATTESTATION_DETAIL values(nextval('S_ATTESTATION_DETAIL'), '123456', 'abc.gmail.com');
insert into T_ATTESTATION_DETAIL values(nextval('S_ATTESTATION_DETAIL'), '234567', 'xyz.gmail.com');
commit;

insert into T_ATTESTATION_AUDIT_REF values(nextval('S_ATTESTATION_AUD_REF'), 1, 1);
insert into T_ATTESTATION_AUDIT_REF values(nextval('S_ATTESTATION_AUD_REF'), 2, 2);
insert into T_ATTESTATION_AUDIT_REF values(nextval('S_ATTESTATION_AUD_REF'), 1, 3);
insert into T_ATTESTATION_AUDIT_REF values(nextval('S_ATTESTATION_AUD_REF'), 2, 4);
commit;