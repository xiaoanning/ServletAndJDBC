
drop table test_user cascade constraint ;

create table test_user( 
    username varchar2(15) primary key,
    password varchar2(6) not null check( length(password)=6 )
);

insert into test_user values('huxz','123456');
insert into test_user values('liucy','123456');
insert into test_user values('luxw','123456');

commit;