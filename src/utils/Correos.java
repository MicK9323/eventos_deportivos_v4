package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Correos {
	
//	Enviar correo sin adjunto
	public void enviarConfirmacion(String destinatario) {
		try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "mail.mcaproyectos.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "26");
            props.setProperty("mail.smtp.user", "info@mcaproyectos.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("info@mcaproyectos.com")); // quien envia
            message.addRecipient(
                Message.RecipientType.TO,// a quien va el correo
                new InternetAddress(destinatario));
            message.setSubject("PREINSCRIPCION DE EQUIPO");
            message.setText(
            		
            		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>\r\n" + 
            		"    <!--[if gte mso 9]><xml>\r\n" + 
            		"     <o:OfficeDocumentSettings>\r\n" + 
            		"      <o:AllowPNG/>\r\n" + 
            		"      <o:PixelsPerInch>96</o:PixelsPerInch>\r\n" + 
            		"     </o:OfficeDocumentSettings>\r\n" + 
            		"    </xml><![endif]-->\r\n" + 
            		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
            		"    <meta name=\"viewport\" content=\"width=device-width\">\r\n" + 
            		"    <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\r\n" + 
            		"    <title>Empty Template</title>\r\n" + 
            		"    <!--[if !mso]><!-- -->\r\n" + 
            		"	<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
            		"	<!--<![endif]-->\r\n" + 
            		"    \r\n" + 
            		"    <style type=\"text/css\" id=\"media-query\">\r\n" + 
            		"      body {\r\n" + 
            		"  margin: 0;\r\n" + 
            		"  padding: 0; }\r\n" + 
            		"\r\n" + 
            		"table, tr, td {\r\n" + 
            		"  vertical-align: top;\r\n" + 
            		"  border-collapse: collapse; }\r\n" + 
            		"\r\n" + 
            		".ie-browser table, .mso-container table {\r\n" + 
            		"  table-layout: fixed; }\r\n" + 
            		"\r\n" + 
            		"* {\r\n" + 
            		"  line-height: inherit; }\r\n" + 
            		"\r\n" + 
            		"a[x-apple-data-detectors=true] {\r\n" + 
            		"  color: inherit !important;\r\n" + 
            		"  text-decoration: none !important; }\r\n" + 
            		"\r\n" + 
            		"[owa] .img-container div, [owa] .img-container button {\r\n" + 
            		"  display: block !important; }\r\n" + 
            		"\r\n" + 
            		"[owa] .fullwidth button {\r\n" + 
            		"  width: 100% !important; }\r\n" + 
            		"\r\n" + 
            		"[owa] .block-grid .col {\r\n" + 
            		"  display: table-cell;\r\n" + 
            		"  float: none !important;\r\n" + 
            		"  vertical-align: top; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .num12, .ie-browser .block-grid, [owa] .num12, [owa] .block-grid {\r\n" + 
            		"  width: 620px !important; }\r\n" + 
            		"\r\n" + 
            		".ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {\r\n" + 
            		"  line-height: 100%; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .mixed-two-up .num4, [owa] .mixed-two-up .num4 {\r\n" + 
            		"  width: 204px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .mixed-two-up .num8, [owa] .mixed-two-up .num8 {\r\n" + 
            		"  width: 408px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.two-up .col, [owa] .block-grid.two-up .col {\r\n" + 
            		"  width: 310px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.three-up .col, [owa] .block-grid.three-up .col {\r\n" + 
            		"  width: 206px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.four-up .col, [owa] .block-grid.four-up .col {\r\n" + 
            		"  width: 155px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.five-up .col, [owa] .block-grid.five-up .col {\r\n" + 
            		"  width: 124px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.six-up .col, [owa] .block-grid.six-up .col {\r\n" + 
            		"  width: 103px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.seven-up .col, [owa] .block-grid.seven-up .col {\r\n" + 
            		"  width: 88px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.eight-up .col, [owa] .block-grid.eight-up .col {\r\n" + 
            		"  width: 77px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.nine-up .col, [owa] .block-grid.nine-up .col {\r\n" + 
            		"  width: 68px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.ten-up .col, [owa] .block-grid.ten-up .col {\r\n" + 
            		"  width: 62px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.eleven-up .col, [owa] .block-grid.eleven-up .col {\r\n" + 
            		"  width: 56px !important; }\r\n" + 
            		"\r\n" + 
            		".ie-browser .block-grid.twelve-up .col, [owa] .block-grid.twelve-up .col {\r\n" + 
            		"  width: 51px !important; }\r\n" + 
            		"\r\n" + 
            		"@media only screen and (min-width: 640px) {\r\n" + 
            		"  .block-grid {\r\n" + 
            		"    width: 620px !important; }\r\n" + 
            		"  .block-grid .col {\r\n" + 
            		"    vertical-align: top; }\r\n" + 
            		"    .block-grid .col.num12 {\r\n" + 
            		"      width: 620px !important; }\r\n" + 
            		"  .block-grid.mixed-two-up .col.num4 {\r\n" + 
            		"    width: 204px !important; }\r\n" + 
            		"  .block-grid.mixed-two-up .col.num8 {\r\n" + 
            		"    width: 408px !important; }\r\n" + 
            		"  .block-grid.two-up .col {\r\n" + 
            		"    width: 310px !important; }\r\n" + 
            		"  .block-grid.three-up .col {\r\n" + 
            		"    width: 206px !important; }\r\n" + 
            		"  .block-grid.four-up .col {\r\n" + 
            		"    width: 155px !important; }\r\n" + 
            		"  .block-grid.five-up .col {\r\n" + 
            		"    width: 124px !important; }\r\n" + 
            		"  .block-grid.six-up .col {\r\n" + 
            		"    width: 103px !important; }\r\n" + 
            		"  .block-grid.seven-up .col {\r\n" + 
            		"    width: 88px !important; }\r\n" + 
            		"  .block-grid.eight-up .col {\r\n" + 
            		"    width: 77px !important; }\r\n" + 
            		"  .block-grid.nine-up .col {\r\n" + 
            		"    width: 68px !important; }\r\n" + 
            		"  .block-grid.ten-up .col {\r\n" + 
            		"    width: 62px !important; }\r\n" + 
            		"  .block-grid.eleven-up .col {\r\n" + 
            		"    width: 56px !important; }\r\n" + 
            		"  .block-grid.twelve-up .col {\r\n" + 
            		"    width: 51px !important; } }\r\n" + 
            		"\r\n" + 
            		"@media (max-width: 640px) {\r\n" + 
            		"  .block-grid, .col {\r\n" + 
            		"    min-width: 320px !important;\r\n" + 
            		"    max-width: 100% !important;\r\n" + 
            		"    display: block !important; }\r\n" + 
            		"  .block-grid {\r\n" + 
            		"    width: calc(100% - 40px) !important; }\r\n" + 
            		"  .col {\r\n" + 
            		"    width: 100% !important; }\r\n" + 
            		"    .col > div {\r\n" + 
            		"      margin: 0 auto; }\r\n" + 
            		"  img.fullwidth, img.fullwidthOnMobile {\r\n" + 
            		"    max-width: 100% !important; }\r\n" + 
            		"  .no-stack .col {\r\n" + 
            		"    min-width: 0 !important;\r\n" + 
            		"    display: table-cell !important; }\r\n" + 
            		"  .no-stack.two-up .col {\r\n" + 
            		"    width: 50% !important; }\r\n" + 
            		"  .no-stack.mixed-two-up .col.num4 {\r\n" + 
            		"    width: 33% !important; }\r\n" + 
            		"  .no-stack.mixed-two-up .col.num8 {\r\n" + 
            		"    width: 66% !important; }\r\n" + 
            		"  .no-stack.three-up .col.num4 {\r\n" + 
            		"    width: 33% !important; }\r\n" + 
            		"  .no-stack.four-up .col.num3 {\r\n" + 
            		"    width: 25% !important; } }\r\n" + 
            		"\r\n" + 
            		"    </style>\r\n" + 
            		"</head>\r\n" + 
            		"<body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #FFFFFF\">\r\n" + 
            		"  <style type=\"text/css\" id=\"media-query-bodytag\">\r\n" + 
            		"    @media (max-width: 520px) {\r\n" + 
            		"      .block-grid {\r\n" + 
            		"        min-width: 320px!important;\r\n" + 
            		"        max-width: 100%!important;\r\n" + 
            		"        width: 100%!important;\r\n" + 
            		"        display: block!important;\r\n" + 
            		"      }\r\n" + 
            		"\r\n" + 
            		"      .col {\r\n" + 
            		"        min-width: 320px!important;\r\n" + 
            		"        max-width: 100%!important;\r\n" + 
            		"        width: 100%!important;\r\n" + 
            		"        display: block!important;\r\n" + 
            		"      }\r\n" + 
            		"\r\n" + 
            		"        .col > div {\r\n" + 
            		"          margin: 0 auto;\r\n" + 
            		"        }\r\n" + 
            		"\r\n" + 
            		"      img.fullwidth {\r\n" + 
            		"        max-width: 100%!important;\r\n" + 
            		"      }\r\n" + 
            		"			img.fullwidthOnMobile {\r\n" + 
            		"        max-width: 100%!important;\r\n" + 
            		"      }\r\n" + 
            		"      .no-stack .col {\r\n" + 
            		"				min-width: 0!important;\r\n" + 
            		"				display: table-cell!important;\r\n" + 
            		"			}\r\n" + 
            		"			.no-stack.two-up .col {\r\n" + 
            		"				width: 50%!important;\r\n" + 
            		"			}\r\n" + 
            		"			.no-stack.mixed-two-up .col.num4 {\r\n" + 
            		"				width: 33%!important;\r\n" + 
            		"			}\r\n" + 
            		"			.no-stack.mixed-two-up .col.num8 {\r\n" + 
            		"				width: 66%!important;\r\n" + 
            		"			}\r\n" + 
            		"			.no-stack.three-up .col.num4 {\r\n" + 
            		"				width: 33%!important\r\n" + 
            		"			}\r\n" + 
            		"			.no-stack.four-up .col.num3 {\r\n" + 
            		"				width: 25%!important\r\n" + 
            		"			}\r\n" + 
            		"    }\r\n" + 
            		"  </style>\r\n" + 
            		"  <!--[if IE]><div class=\"ie-browser\"><![endif]-->\r\n" + 
            		"  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n" + 
            		"  <table class=\"nl-container\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #FFFFFF;width: 100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
            		"	<tbody>\r\n" + 
            		"	<tr style=\"vertical-align: top\">\r\n" + 
            		"		<td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n" + 
            		"    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #FFFFFF;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid two-up \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"310\" style=\" width:310px; padding-right: 10px; padding-left: 10px; padding-top:5px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num6\" style=\"max-width: 320px;min-width: 310px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 10px; padding-left: 10px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><![endif]-->\r\n" + 
            		"<div style=\"color:#555555;line-height:120%;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">	\r\n" + 
            		"	<div style=\"font-size:12px;line-height:14px;color:#555555;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px\"><span style=\"font-size: 20px; line-height: 24px;\"><strong>EVENTOS DEPORTIVOS</strong></span><br></p></div>	\r\n" + 
            		"</div>\r\n" + 
            		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"              <!--[if (mso)|(IE)]></td><td align=\"center\" width=\"310\" style=\" width:310px; padding-right: 10px; padding-left: 10px; padding-top:5px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num6\" style=\"max-width: 320px;min-width: 310px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 10px; padding-left: 10px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    &#160;\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 15px;\">\r\n" + 
            		"  <!--[if (mso)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px;padding-left: 10px; padding-top: 10px; padding-bottom: 15px;\"><table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td><![endif]-->\r\n" + 
            		"  <div align=\"center\"><div style=\"border-top: 1px solid #222222; width:100%; line-height:1px; height:1px; font-size:1px;\">&#160;</div></div>\r\n" + 
            		"  <!--[if (mso)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"</div>\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <div align=\"center\" class=\"img-container center  autowidth \" style=\"padding-right: 0px;  padding-left: 0px;\">\r\n" + 
            		"<!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px;\" align=\"center\"><![endif]-->\r\n" + 
            		"  <img class=\"center  autowidth \" align=\"center\" border=\"0\" src=\"https://pro-bee-template-catalog-public.s3.amazonaws.com/templates/default/18/okok.gif\" alt=\"Image\" title=\"Image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: 0;height: auto;float: none;width: 100%;max-width: 250px\" width=\"250\">\r\n" + 
            		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
            		"</div>\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:10px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:10px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 5px;\"><![endif]-->\r\n" + 
            		"<div style=\"font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;color:#000000; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 5px;\">	\r\n" + 
            		"	<div style=\"font-size:12px;line-height:14px;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;color:#000000;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><strong><span style=\"font-size: 18px; line-height: 21px;\">Tu equipo ha sido preinscrito correctamente<br></span></strong></p><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><strong><span style=\"font-size: 18px; line-height: 21px;\">Realiza el pago para culminar el proceso!</span></strong></p></div>	\r\n" + 
            		"</div>\r\n" + 
            		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                  \r\n" + 
            		"                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 25px;\"><![endif]-->\r\n" + 
            		"<div style=\"font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;color:#71777D; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 25px;\">	\r\n" + 
            		"	<div style=\"font-size:12px;line-height:14px;font-family:Lato, Tahoma, Verdana, Segoe, sans-serif;color:#71777D;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\">Este correo valida la preinscripcion de tu equipo.</p></div>	\r\n" + 
            		"</div>\r\n" + 
            		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">\r\n" + 
            		"  <!--[if (mso)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px;padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td><![endif]-->\r\n" + 
            		"  <div align=\"center\"><div style=\"border-top: 1px dotted #CCCCCC; width:100%; line-height:1px; height:1px; font-size:1px;\">&#160;</div></div>\r\n" + 
            		"  <!--[if (mso)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"</div>\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 15px; padding-bottom: 15px;\">\r\n" + 
            		"  <!--[if (mso)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px;padding-left: 10px; padding-top: 15px; padding-bottom: 15px;\"><table width=\"100%\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td><![endif]-->\r\n" + 
            		"  <div align=\"center\"><div style=\"border-top: 1px dotted #CCCCCC; width:100%; line-height:1px; height:1px; font-size:1px;\">&#160;</div></div>\r\n" + 
            		"  <!--[if (mso)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"</div>\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:0px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                              \r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>    <div style=\"background-color:transparent;\">\r\n" + 
            		"      <div style=\"Margin: 0 auto;min-width: 320px;max-width: 620px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \">\r\n" + 
            		"        <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\r\n" + 
            		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"background-color:transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width: 620px;\"><tr class=\"layout-full-width\" style=\"background-color:transparent;\"><![endif]-->\r\n" + 
            		"\r\n" + 
            		"              <!--[if (mso)|(IE)]><td align=\"center\" width=\"620\" style=\" width:620px; padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n" + 
            		"            <div class=\"col num12\" style=\"min-width: 320px;max-width: 620px;display: table-cell;vertical-align: top;\">\r\n" + 
            		"              <div style=\"background-color: transparent; width: 100% !important;\">\r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--><div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"><!--<![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><![endif]-->\r\n" + 
            		"<div style=\"font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;color:#555555; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\">	\r\n" + 
            		"	<div style=\"font-size:12px;line-height:14px;font-family:Lato, Tahoma, Verdana, Segoe, sans-serif;color:#555555;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><span style=\"font-size: 12px; line-height: 14px;\">Copyright © 2017 Miguel Cortegana</span><span style=\"font-size: 12px; line-height: 14px;\"></span></p></div>	\r\n" + 
            		"</div>\r\n" + 
            		"<!--[if mso]></td></tr></table><![endif]-->\r\n" + 
            		"\r\n" + 
            		"                  \r\n" + 
            		"              <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + 
            		"              </div>\r\n" + 
            		"            </div>\r\n" + 
            		"          <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\r\n" + 
            		"        </div>\r\n" + 
            		"      </div>\r\n" + 
            		"    </div>   <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
            		"		</td>\r\n" + 
            		"  </tr>\r\n" + 
            		"  </tbody>\r\n" + 
            		"  </table>\r\n" + 
            		"  <!--[if (mso)|(IE)]></div><![endif]-->\r\n" + 
            		"\r\n" + 
            		"\r\n" + 
            		"</body></html>",
            		"ISO-8859-1",
            		"html"
            		);
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("info@mcaproyectos.com", "UMh!l$9#j@c?");
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	
}
