INSERT INTO public.utenti(
	id, enabled, password, username)
	VALUES (1, true, '$2a$04$WEScpSZp3h4x5saClbUTMOcDySamMccuWo.42.xe4UKCv8EZ0XrVW', 'Generale');

INSERT INTO public.utenti(
	id, enabled, password, username)
	VALUES (2, true, '$2a$04$NcPbgYfbT2lYH5eYIca2eO.zxy0Qz7afq0Wtyoc3MKyeO5ZOpP5U.', 'Tenente');

INSERT INTO public.utenti(
	id, enabled, password, username)
	VALUES (3, true, '$2a$04$DYJ5XVXnYc32p94bOs4D5OhFnxAa7qnd4SwWP26Y4fCsA5BjqOZ7C', 'Capitano');



INSERT INTO public.ruoli_utente(
	ruolo_utente_id, ruolo, utente_id)
	VALUES (1, 'ROLE_ADMIN', 1);

INSERT INTO public.ruoli_utente(
	ruolo_utente_id, ruolo, utente_id)
	VALUES (2, 'ROLE_UTENTE', 2);

INSERT INTO public.ruoli_utente(
	ruolo_utente_id, ruolo, utente_id)
	VALUES (3, 'ROLE_UTENTE', 3);



INSERT INTO public.centro(
	id, cap_max_allievi, email, indirizzo, nome, telefono, utente_id)
	VALUES (1, 25, 'aereafinanza@finanza.it', 'Pratica di mare', 'Sezione Aerea Guardia di Finanza', 0658813, 2);

INSERT INTO public.centro(
	id, cap_max_allievi, email, indirizzo, nome, telefono, utente_id)
	VALUES (2, 22, 'navale@finanza.it', 'Lungo mare duca degli abruzzi', 'Sezione Operativa Navale Guardia di Finanza', 054331283, 3);



INSERT INTO public.allievo(
	id, cognome, data, email, luogo_nascita, nome, telefono, centro_id)
	VALUES (1, 'Tinelli', '10/02/1988', 'tinelli@tiscali.it', 'Padova', 'Adolfo', 33564821, 1);

INSERT INTO public.allievo(
	id, cognome, data, email, luogo_nascita, nome, telefono, centro_id)
	VALUES (2, 'Lambretta', '25/12/1990', 'tinelli@libero.it', 'Ascoli', 'Lamberto', 348243771, 2);



INSERT INTO public.corso(
	id, completato, data, nome, centro_operativo_id)
	VALUES (1, false, '10/06/2019', 'Concorso Allievi Marescialli', 1);

INSERT INTO public.corso(
	id, completato, data, nome, centro_operativo_id)
	VALUES (2, true, '01/08/2014', 'Concorso Allievi ViceBrigadieri', 2);


