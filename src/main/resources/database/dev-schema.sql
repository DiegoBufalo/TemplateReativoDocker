-- public.tb_abordagem definition

-- Drop table

-- DROP TABLE public.tb_abordagem;
CREATE schema IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.tb_abordagem (
	cd_abordagem int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
	ds_abordagem varchar(255) NOT NULL,
	dt_abordagem timestamp NOT NULL,
	ds_chavefamrepr varchar(30) NOT NULL,
	nm_repfamilia varchar(255) NOT NULL,
	classificacao int4 NULL,
	CONSTRAINT tb_abordagem_pkey PRIMARY KEY (cd_abordagem)
);