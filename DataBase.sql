prompt PL/SQL Developer Export Tables for user PRACTISER@ORCL
prompt Created by 11209 on 2019年5月22日
set feedback off
set define off

prompt Disabling triggers for ACCOUNT...
alter table ACCOUNT disable all triggers;
prompt Disabling triggers for ATHLETES...
alter table ATHLETES disable all triggers;
prompt Disabling triggers for CAPTAIN...
alter table CAPTAIN disable all triggers;
prompt Disabling triggers for COACH...
alter table COACH disable all triggers;
prompt Disabling triggers for COMPETITION...
alter table COMPETITION disable all triggers;
prompt Disabling triggers for DOCTOR...
alter table DOCTOR disable all triggers;
prompt Disabling triggers for ENROLLMENT...
alter table ENROLLMENT disable all triggers;
prompt Disabling triggers for M_ITEM...
alter table M_ITEM disable all triggers;
prompt Disabling triggers for PARTICIPATION...
alter table PARTICIPATION disable all triggers;
prompt Disabling triggers for REFEREE...
alter table REFEREE disable all triggers;
prompt Disabling triggers for REFGROUP...
alter table REFGROUP disable all triggers;
prompt Disabling triggers for SCORES...
alter table SCORES disable all triggers;
prompt Disabling triggers for TEAM...
alter table TEAM disable all triggers;
prompt Deleting TEAM...
delete from TEAM;
commit;
prompt Deleting SCORES...
delete from SCORES;
commit;
prompt Deleting REFGROUP...
delete from REFGROUP;
commit;
prompt Deleting REFEREE...
delete from REFEREE;
commit;
prompt Deleting PARTICIPATION...
delete from PARTICIPATION;
commit;
prompt Deleting M_ITEM...
delete from M_ITEM;
commit;
prompt Deleting ENROLLMENT...
delete from ENROLLMENT;
commit;
prompt Deleting DOCTOR...
delete from DOCTOR;
commit;
prompt Deleting COMPETITION...
delete from COMPETITION;
commit;
prompt Deleting COACH...
delete from COACH;
commit;
prompt Deleting CAPTAIN...
delete from CAPTAIN;
commit;
prompt Deleting ATHLETES...
delete from ATHLETES;
commit;
prompt Deleting ACCOUNT...
delete from ACCOUNT;
commit;
prompt Loading ACCOUNT...
insert into ACCOUNT (account, password, authority, id)
values ('46579', '12345', '代表队', '030');
insert into ACCOUNT (account, password, authority, id)
values ('3511', '12345', '代表队', '002');
insert into ACCOUNT (account, password, authority, id)
values ('3510', '12345', '代表队', '003');
insert into ACCOUNT (account, password, authority, id)
values ('000', '123456789', '管理员', '000');
insert into ACCOUNT (account, password, authority, id)
values ('3506', '12345', '代表队', '022');
insert into ACCOUNT (account, password, authority, id)
values ('RM0000', '12345', '裁判长', 'M0000');
insert into ACCOUNT (account, password, authority, id)
values ('3902', '12345', '代表队', '025');
insert into ACCOUNT (account, password, authority, id)
values ('3903', '12345', '代表队', '026');
insert into ACCOUNT (account, password, authority, id)
values ('3904', '12345', '代表队', '027');
insert into ACCOUNT (account, password, authority, id)
values ('3905', '12345', '代表队', '028');
insert into ACCOUNT (account, password, authority, id)
values ('3512', '12345', '代表队', '001');
insert into ACCOUNT (account, password, authority, id)
values ('3509', '12345', '代表队', '004');
insert into ACCOUNT (account, password, authority, id)
values ('3508', '12345', '代表队', '005');
insert into ACCOUNT (account, password, authority, id)
values ('R20', '12345', '总裁判', '10');
insert into ACCOUNT (account, password, authority, id)
values ('R21', '12345', '裁判', '1011');
insert into ACCOUNT (account, password, authority, id)
values ('R22', '12345', '裁判', '1012');
insert into ACCOUNT (account, password, authority, id)
values ('R23', '12345', '裁判', '1013');
insert into ACCOUNT (account, password, authority, id)
values ('R24', '12345', '裁判', '1014');
insert into ACCOUNT (account, password, authority, id)
values ('3987', '12345', '代表队', '029');
insert into ACCOUNT (account, password, authority, id)
values ('R11', '12345', '裁判', '56');
insert into ACCOUNT (account, password, authority, id)
values ('R12', '12345', '裁判', '57');
insert into ACCOUNT (account, password, authority, id)
values ('R13', '12345', '裁判', '58');
insert into ACCOUNT (account, password, authority, id)
values ('R00', '12345', '总裁判', '0');
insert into ACCOUNT (account, password, authority, id)
values ('R01', '12345', '裁判', '01');
insert into ACCOUNT (account, password, authority, id)
values ('R02', '12345', '裁判', '02');
insert into ACCOUNT (account, password, authority, id)
values ('R03', '12345', '裁判', '03');
insert into ACCOUNT (account, password, authority, id)
values ('R04', '12345', '裁判', '04');
insert into ACCOUNT (account, password, authority, id)
values ('R10', '12345', '总裁判', '5');
insert into ACCOUNT (account, password, authority, id)
values ('R14', '12345', '裁判', '59');
insert into ACCOUNT (account, password, authority, id)
values ('3507', '12345', '代表队', '021');
insert into ACCOUNT (account, password, authority, id)
values ('3901', '12345', '代表队', '024');
commit;
prompt 31 records loaded
prompt Loading ATHLETES...
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('027', '张一', '12345678909011', 12, '男', 0, '024', '9011');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('999', '戴道瑭', '1234567890512285', 12, '男', null, '001', '512285');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('001', 'd', '12345678905111', 12, '男', 0, '002', '5111');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('013', 'y', '12345678905082', 8, '男', 0, '005', '5082');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('006', 't', '12345678905083', 9, '女', 0, '005', '5083');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('003', 'd', '12345678905101', 12, '男', 0, '003', '5101');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('005', 'e', '12345678905102', 11, '男', 0, '003', '5102');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('000', 'f', '12345678905103', 10, '女', 0, '003', '5103');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('002', 'h', '12345678905104', 9, '女', 0, '003', '5104');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('015', 'h', '12345678905071', 7, '男', 0, '021', '5071');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('007', 'r', '12345678905091', 9, '男', 0, '004', '5091');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('009', 't', '12345678905092', 10, '男', 0, '004', '5092');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('004', 'y', '12345678905093', 11, '女', 0, '004', '5093');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('011', 'u', '12345678905081', 7, '男', 0, '005', '5081');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('017', 'g', '12345678905072', 8, '男', 0, '021', '5072');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('019', 'f', '12345678905073', 10, '男', 0, '021', '5073');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('008', 's', '12345678905074', 11, '女', 0, '021', '5074');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('021', 'v', '12345678905061', 7, '男', 0, '022', '5061');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('023', 'b', '12345678905062', 8, '男', 0, '022', '5062');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('025', 'n', '12345678905063', 9, '男', 0, '022', '5063');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('010', 'm', '12345678905064', 10, '女', 0, '022', '5064');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('012', 'n', '12345678905065', 11, '女', 0, '022', '5065');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('033', 'a', '896451320', 12, '男', 0, '027', '1564');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('035', '狼队', '12345678909871', 9, '男', 0, '029', '9871');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('037', '虎队', '12345678909872', 10, '男', 0, '029', '9872');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('014', '豹队', '12345678909873', 11, '女', 0, '029', '9873');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('016', '狮队', '12345678909874', 12, '女', 0, '029', '9874');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('039', 'afas', 'dsfs', 8, '男', 0, '028', 'dfsf');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('031', '钱一', '12345678909041', 12, '男', 0, '027', '9041');
insert into ATHLETES (ath_id, athname, identification, athage, athsex, cul_goal, team_id, tel)
values ('029', '赵一', '12345678909021', 11, '男', 0, '025', '9021');
commit;
prompt 30 records loaded
prompt Loading CAPTAIN...
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('901Captain', '9010', '12345678909010', '024');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('512领队', '51200', '123456789051200', '001');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('a', '5100', '12345678905100', '003');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('l', '5070', '12345678905070', '021');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('a', '5110', '12345678905110', '002');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('q', '5090', '12345678905090', '004');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('p', '5080', '12345678905080', '005');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('z', '5060', '12345678905060', '022');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('987Captain', '9870', '12345678909870', '029');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('asfa', 'asfda', 'sfa', '028');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('904Captain', '9040', '12345678909040', '027');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('asdf', '8654', '1111111111', '027');
insert into CAPTAIN (c_name, tel, identification, team_id)
values ('902Captain', '9020', '12345678909020', '025');
commit;
prompt 13 records loaded
prompt Loading COACH...
insert into COACH (co_name, sex, tel, identification, team_id)
values ('901Coach', '女', '901000', '1234567890901000', '024');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('512教练员', '女', '51222', '123456789051222', '001');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('c', '女', '510000', '1234567890510000', '003');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('c', '女', '511000', '1234567890511000', '002');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('e', '女', '509000', '1234567890509000', '004');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('j', '女', '507000', '1234567890507000', '021');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('i', '女', '508000', '1234567890508000', '005');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('c', '女', '506000', '1234567890506000', '022');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('sdfgg', '女', '15648', '54132', '027');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('987Coach', '女', '987000', '1234567890987000', '029');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('asdfa', '女', 'asf', 'asd', '028');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('904Coach', '女', '904000', '1234567890904000', '027');
insert into COACH (co_name, sex, tel, identification, team_id)
values ('902Coach', '女', '902000', '1234567890902000', '025');
commit;
prompt 13 records loaded
prompt Loading COMPETITION...
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('FE107085', 'FE10708', '0', 'N', '2019-05-09 NaN:30');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('PB107080', 'PB10708', '2', 'N', '2019-05-15 NaN:30');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('VH109103', 'VH10910', '0', 'N', '2019-05-06 NaN:30');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('FE107087', 'FE10708', '2', 'N', '2019-05-15 NaN:30');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('VH111124', 'VH11112', '0', 'N', '2019-05-06 NaN:30');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('FE109106', 'FE10910', '1', 'N', '2019-05-07 13:00');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('HB111121', 'HB11112', '0', 'N', '2019-05-11 NaN:30');
insert into COMPETITION (com_id, item_id, ref_group_id, finals, time)
values ('VH107082', 'VH10708', '0', 'N', '2019-05-06 13:00');
commit;
prompt 8 records loaded
prompt Loading DOCTOR...
insert into DOCTOR (d_name, tel, identification, team_id)
values ('901Doctor', '90100', '123456789090100', '024');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('512队医', '51211', '123456789051211', '001');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('b', '51000', '123456789051000', '003');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('k', '50700', '123456789050700', '021');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('b', '51100', '123456789051100', '002');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('w', '50900', '123456789050900', '004');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('o', '50800', '123456789050800', '005');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('x', '50600', '123456789050600', '022');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('987Doctor', '98700', '123456789098700', '029');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('asda', 'dfd', 'sdfs', '028');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('904Doctor', '90400', '123456789090400', '027');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('sdfg', '48651', '15465132', '027');
insert into DOCTOR (d_name, tel, identification, team_id)
values ('902Doctor', '90200', '123456789090200', '025');
commit;
prompt 13 records loaded
prompt Loading ENROLLMENT...
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('001', 'PB11112', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'HB11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'PB11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'RI11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'VH11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('001', 'HB11112', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('001', 'RI11112', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('001', 'VH11112', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('027', 'HB11112', '024');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('027', 'PB11112', '024');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('027', 'VH11112', '024');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('001', 'PB11112', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('001', 'RI11112', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('003', 'PB11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('003', 'RI11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('003', 'VH11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('005', 'HB11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('005', 'VH11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('003', 'HB11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('005', 'PB11112', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('000', 'BB00910', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('002', 'FE00910', '003');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'PB10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'VH10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'FE10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'TR10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'PB10708', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'VH10708', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'FE10708', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'TR10708', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('004', 'VH00708', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'HB10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'RI10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'FE10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'TR10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'PB10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'VH10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'FE10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('009', 'TR10910', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('004', 'VH01112', '004');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('011', 'RI10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('011', 'FE10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('011', 'PH10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('011', 'TR10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('013', 'HB10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('013', 'PB10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('013', 'RI10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('013', 'VH10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('013', 'FE10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('013', 'PH10708', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('006', 'VH00910', '005');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('015', 'HB10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('015', 'PB10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('015', 'VH10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('015', 'FE10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('015', 'PH10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('017', 'HB10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('017', 'VH10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('017', 'FE10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('017', 'PH10708', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('019', 'PB10910', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('019', 'RI10910', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('019', 'VH10910', '021');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('021', 'HB10708', '022');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('023', 'PB10708', '022');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('025', 'RI10910', '022');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('010', 'FE00910', '022');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('012', 'TR01112', '022');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('035', 'HB10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('035', 'PB10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('035', 'RI10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('035', 'PH10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('035', 'TR10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('037', 'HB10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('037', 'PB10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('037', 'RI10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('037', 'FE10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('037', 'PH10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('037', 'TR10910', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('014', 'VH01112', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('014', 'BB01112', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('014', 'TR01112', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('016', 'VH01112', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('016', 'AB01112', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('016', 'BB01112', '029');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('039', 'HB10708', '028');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('039', 'PB10708', '028');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'HB11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'PB11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'RI11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('999', 'VH11112', '001');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('005', 'PB10910', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('005', 'RI10910', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('007', 'RI10910', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('002', 'VH00910', '002');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('029', 'HB11112', '025');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('029', 'PB11112', '025');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('029', 'RI11112', '025');
insert into ENROLLMENT (ath_id, item_id, team_id)
values ('029', 'VH11112', '025');
commit;
prompt 99 records loaded
prompt Loading M_ITEM...
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('单杠', 'HB10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('单杠', 'HB10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('单杠', 'HB11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('双杠', 'PB10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('双杠', 'PB10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('双杠', 'PB11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('跳马', 'VH10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('跳马', 'VH10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('跳马', 'VH11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('跳马', 'VH00708', '7-8', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('跳马', 'VH00910', '9-10', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('跳马', 'VH01112', '11-12', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('吊环', 'RI10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('吊环', 'RI10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('吊环', 'RI11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('鞍马', 'PH10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('鞍马', 'PH10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('鞍马', 'PH11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('自由体操', 'FE10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('自由体操', 'FE10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('自由体操', 'FE11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('自由体操', 'FE00708', '7-8', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('自由体操', 'FE00910', '9-10', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('自由体操', 'FE01112', '11-12' || chr(10) || '', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('蹦床', 'TR10708', '7-8', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('蹦床', 'TR10910', '9-10', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('蹦床', 'TR11112', '11-12', '男', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('蹦床', 'TR00708', '7-8', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('蹦床', 'TR00910', '9-10', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('蹦床', 'TR01112', '11-12', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('高低杠', 'AB00708', '7-8', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('高低杠', 'AB00910', '9-10', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('高低杠', 'AB01112', '11-12', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('平衡木', 'BB00708', '7-8', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('平衡木', 'BB00910', '9-10', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('平衡木', 'BB01112', '11-12', '女', 'M0000');
insert into M_ITEM (item_name, item_id, age, sex, chief_ref)
values ('测试项目1', 'C001', '0-100', '男', 'M0000');
commit;
prompt 37 records loaded
prompt Loading PARTICIPATION...
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('009', 'PB107080', 199, 1, 0, 0, 3, 't');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('013', 'PB107080', 198, 2, 0, 0, 3, 'y');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('015', 'PB107080', 197, 3, 0, 0, 3, 'h');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('023', 'PB107080', 196, 4, 0, 0, 3, 'b');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('007', 'VH109103', null, null, null, null, 0, 'r');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('009', 'VH109103', null, null, null, null, 1, 't');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('019', 'VH109103', null, null, null, null, 1, 'f');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('009', 'FE107085', null, null, null, null, 0, 't');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('011', 'FE107085', null, null, null, null, 0, 'u');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('013', 'FE107085', null, null, null, null, 0, 'y');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('015', 'FE107087', 115, null, 0, 0, 2, 'h');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('017', 'FE107087', 26, null, 0, 0, 2, 'g');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('029', 'VH111124', null, null, null, null, 0, '赵一');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('027', 'VH111124', null, null, null, null, 0, '张一');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('005', 'VH111124', null, null, null, null, 0, 'e');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('003', 'VH111124', null, null, null, null, 0, 'd');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('001', 'VH111124', null, null, null, null, 0, 'd');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('999', 'VH111124', null, null, null, null, 0, '戴道瑭');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('007', 'FE109106', 197, null, 8, 2, 2, 'r');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('009', 'FE109106', 191, null, 7, 0, 2, 't');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('037', 'FE109106', 187, null, 0, 2, 2, '虎队');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('015', 'VH107082', null, null, null, null, 0, 'h');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('999', 'HB111121', null, null, null, null, 0, '戴道瑭');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('029', 'HB111121', null, null, null, null, 0, '赵一');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('027', 'HB111121', null, null, null, null, 0, '张一');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('001', 'HB111121', null, null, null, null, 0, 'd');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('005', 'HB111121', null, null, null, null, 0, 'e');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('003', 'HB111121', null, null, null, null, 0, 'd');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('009', 'VH107082', null, null, null, null, 0, 't');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('013', 'VH107082', null, null, null, null, 0, 'y');
insert into PARTICIPATION (ath_id, com_id, result, rank, d, p, status, ath_name)
values ('017', 'VH107082', null, null, null, null, 0, 'g');
commit;
prompt 31 records loaded
prompt Loading REFEREE...
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('10', '戢总裁判', '12320', '123456789020', '2');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('1011', '启裁判', '12321', '123456789021', '2');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('1012', '瑞裁判', '12322', '123456789022', '2');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('1013', '带裁判', '12323', '123456789023', '2');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('1014', '飞裁判', '12324', '123456789024', '2');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('56', '道裁判', '12311', '123456789011', '1');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('57', '瑭裁判', '12312', '123456789012', '1');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('58', '天裁判', '12313', '123456789013', '1');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('0', '李总裁判', '12300', '123456789000', '0');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('01', '沛裁判', '12301', '123456789001', '0');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('02', '昊裁判', '12302', '123456789002', '0');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('03', '牛裁判', '12303', '123456789003', '0');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('04', '批裁判', '12304', '123456789004', '0');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('5', '戴总裁判', '12310', '123456789010', '1');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('59', '秀裁判', '12314', '123456789014', '1');
insert into REFEREE (ref_id, ref_name, tel, identification, ref_group)
values ('M0000', '龙裁判长', '5020', '123456789080', 'M');
commit;
prompt 16 records loaded
prompt Loading REFGROUP...
insert into REFGROUP (ref_group_id, group_leader)
values ('2', '10');
insert into REFGROUP (ref_group_id, group_leader)
values ('0', '0');
insert into REFGROUP (ref_group_id, group_leader)
values ('1', '5');
commit;
prompt 3 records loaded
prompt Loading SCORES...
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'PB107080', '1012', 97);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'PB107080', '1012', 99);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('013', 'PB107080', '1012', 98);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('023', 'PB107080', '1012', 96);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('023', 'PB107080', '1014', 0);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('037', 'FE109106', '57', 98);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'VH109103', '03', 88);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('019', 'VH109103', '03', 89);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('019', 'VH109103', '04', 69);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('007', 'FE109106', '57', 89);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'FE109106', '57', 78);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('007', 'FE109106', '59', 99);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'FE109106', '59', 98);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'FE107087', '1011', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('017', 'FE107087', '1011', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'FE107087', '1013', 11);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('017', 'FE107087', '1013', 11);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'FE107087', '1014', 15);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'PB107080', '1014', 0);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('013', 'PB107080', '1014', 0);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'PB107080', '1014', 0);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('017', 'FE107087', '1012', 11);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'VH109103', '01', 86);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('019', 'VH109103', '01', 87);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'VH109103', '04', 89);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('037', 'FE109106', '59', 97);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'FE107087', '1012', 1100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('013', 'PB107080', '1011', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'PB107080', '1011', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('023', 'PB107080', '1011', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('019', 'VH109103', '02', 92);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'VH109103', '02', 97);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'PB107080', '1011', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'PB107080', '1013', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('013', 'PB107080', '1013', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('015', 'PB107080', '1013', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('023', 'PB107080', '1013', 100);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('007', 'FE109106', '56', 98);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'FE109106', '56', 99);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('037', 'FE109106', '56', 72);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('007', 'FE109106', '58', 88);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('009', 'FE109106', '58', 86);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('037', 'FE109106', '58', 88);
insert into SCORES (ath_id, com_id, ref_id, score)
values ('017', 'FE107087', '1014', 15);
commit;
prompt 44 records loaded
prompt Loading TEAM...
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('030', 'hhhh', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('002', 'C3-511', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('003', 'C3-510', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('022', 'C3-506', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('025', 'C3-902', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('026', 'C3-903', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('027', 'C3-904', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('028', 'C3-905', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('001', 'C3-512', null, null, null, 1, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('004', 'C3-509', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('005', 'C3-508', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('029', 'C3-987', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('021', 'C3-507', null, null, null, 0, 0);
insert into TEAM (team_id, team_name, captain, coach, doctor, host, sumscore)
values ('024', 'C3-901', null, null, null, 0, 0);
commit;
prompt 14 records loaded
prompt Enabling triggers for ACCOUNT...
alter table ACCOUNT enable all triggers;
prompt Enabling triggers for ATHLETES...
alter table ATHLETES enable all triggers;
prompt Enabling triggers for CAPTAIN...
alter table CAPTAIN enable all triggers;
prompt Enabling triggers for COACH...
alter table COACH enable all triggers;
prompt Enabling triggers for COMPETITION...
alter table COMPETITION enable all triggers;
prompt Enabling triggers for DOCTOR...
alter table DOCTOR enable all triggers;
prompt Enabling triggers for ENROLLMENT...
alter table ENROLLMENT enable all triggers;
prompt Enabling triggers for M_ITEM...
alter table M_ITEM enable all triggers;
prompt Enabling triggers for PARTICIPATION...
alter table PARTICIPATION enable all triggers;
prompt Enabling triggers for REFEREE...
alter table REFEREE enable all triggers;
prompt Enabling triggers for REFGROUP...
alter table REFGROUP enable all triggers;
prompt Enabling triggers for SCORES...
alter table SCORES enable all triggers;
prompt Enabling triggers for TEAM...
alter table TEAM enable all triggers;

set feedback on
set define on
prompt Done
