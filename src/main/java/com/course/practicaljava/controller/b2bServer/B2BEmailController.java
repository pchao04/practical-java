package com.course.practicaljava.controller.b2bServer;

import com.course.practicaljava.model.request.EmailRequest;
import com.course.practicaljava.model.request.TriggerRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/edi/v1/dispatcher/b2b_email")
@RestController
@Tag(name = "B2B Email", description = "")
public class B2BEmailController {
    @PutMapping("/ignore/{id}")
    @Operation(summary = "ignore error message", description = "忽略錯誤不被watch dog偵測到")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "success") })
    public void ignore(
        @Parameter(description = "id", example = "1234") @PathVariable String id)
    {

    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "get B2B emails",
        description = "檢索B2B郵件")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "success") })

    public ResponseEntity<Object> get(
        @Parameter(description = "search query")  @RequestParam(required = false) String search,
        @Parameter(description = "time range") @RequestParam(required = false) String[] timeRange,
        @Parameter(description = "sort field") @RequestParam(required = false) String sort,
        @Parameter(description = "sort order") @RequestParam(required = false) String order,
        @Parameter(description = "offset") @RequestParam(required = false) Integer offset){

        var entities = new Object();
        //String content = "{"id":1,"name":"ram"}";
        //JSONObject jsonObject= new JSONObject(content );
        //Gson gson = new Gson();
        entities= """
                {
                    "code": 0,
                    "data": {
                        "total": 63,
                        "items": [
                            {
                                "_index": "b2b_email_20220520095414241",
                                "_type": "_doc",
                                "_id": "558ee9bf-3095-42ff-bd3a-99fe83d9d346",
                                "_score": null,
                                "_source": {
                                    "cc": [],
                                    "ignored": false,
                                    "bcc": [],
                                    "attachments": [
                                        {
                                            "fileName": "04958597-A.pdf",
                                            "S3PathKeyName": "attachments/2022-10-13/09-08-52.463.390982fd-92e6-4346-b1e1-3b73f6303453.pdf",
                                            "contentType": "application/pdf; name=04958597-A.pdf"
                                        }
                                    ],
                                    "is_valid_subject": true,
                                    "offset": "35",
                                    "subject": "Invoice [04952620-B] OERT201701L04189",
                                    "messageid": "<SEYPR03MB676994FC229E8C0E7B0824A493259@SEYPR03MB6769.apcprd03.prod.outlook.com>",
                                    "doc_type": "INVOICE_NO",
                                    "INVOICE_NO": "04952620-B",
                                    "HBL_NO": "OERT201701L04189",
                                    "sent": true,
                                    "sentDate": 1665652115000,
                                    "partner": "GRAINGER",
                                    "sender": "",
                                    "updated_timestamp": "2022-10-13T17:08:58+08:00",
                                    "replyTo": [
                                        "fan.mis@oecgroup.com"
                                    ],
                                    "from": "fan.mis@oecgroup.com",
                                    "id": "558ee9bf-3095-42ff-bd3a-99fe83d9d346",
                                    "to": [
                                        "b2b-invoice.test@oecgroup.com"
                                    ],
                                    "value": "{\\"from\\":[\\"fan.mis@oecgroup.com\\"],\\"replyTo\\":[\\"fan.mis@oecgroup.com\\"],\\"to\\":[\\"b2b-invoice.test@oecgroup.com\\"],\\"cc\\":[],\\"bcc\\":[],\\"sender\\":\\"\\",\\"subject\\":\\"Invoice [04952620-B] OERT201701L04189\\",\\"textBody\\":null,\\"htmlBody\\":\\"<html xmlns:v=\\\\\\"urn:schemas-microsoft-com:vml\\\\\\" xmlns:o=\\\\\\"urn:schemas-microsoft-com:office:office\\\\\\" xmlns:w=\\\\\\"urn:schemas-microsoft-com:office:word\\\\\\" xmlns:m=\\\\\\"http://schemas.microsoft.com/office/2004/12/omml\\\\\\" xmlns=\\\\\\"http://www.w3.org/TR/REC-html40\\\\\\">\\\\r\\\\n<head>\\\\r\\\\n<meta http-equiv=\\\\\\"Content-Type\\\\\\" content=\\\\\\"text/html; charset=big5\\\\\\">\\\\r\\\\n<meta name=\\\\\\"Generator\\\\\\" content=\\\\\\"Microsoft Word 15 (filtered medium)\\\\\\">\\\\r\\\\n<style><!--\\\\r\\\\n/* Font Definitions */\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:SimSun;\\\\r\\\\n\\\\tpanose-1:2 1 6 0 3 1 1 1 1 1;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:新細明體;\\\\r\\\\n\\\\tpanose-1:2 2 5 0 0 0 0 0 0 0;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:\\\\\\"Cambria Math\\\\\\";\\\\r\\\\n\\\\tpanose-1:2 4 5 3 5 4 6 3 2 4;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:Calibri;\\\\r\\\\n\\\\tpanose-1:2 15 5 2 2 2 4 3 2 4;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:\\\\\\"\\\\\\\\@SimSun\\\\\\";\\\\r\\\\n\\\\tpanose-1:2 1 6 0 3 1 1 1 1 1;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:\\\\\\"\\\\\\\\@新細明體\\\\\\";\\\\r\\\\n\\\\tpanose-1:2 1 6 1 0 1 1 1 1 1;}\\\\r\\\\n/* Style Definitions */\\\\r\\\\np.MsoNormal, li.MsoNormal, div.MsoNormal\\\\r\\\\n\\\\t{margin:0cm;\\\\r\\\\n\\\\tfont-size:12.0pt;\\\\r\\\\n\\\\tfont-family:\\\\\\"Calibri\\\\\\",sans-serif;}\\\\r\\\\nspan.EmailStyle17\\\\r\\\\n\\\\t{mso-style-type:personal-compose;\\\\r\\\\n\\\\tfont-family:\\\\\\"Calibri\\\\\\",sans-serif;\\\\r\\\\n\\\\tcolor:windowtext;\\\\r\\\\n\\\\tfont-weight:normal;\\\\r\\\\n\\\\tfont-style:normal;}\\\\r\\\\n.MsoChpDefault\\\\r\\\\n\\\\t{mso-style-type:export-only;\\\\r\\\\n\\\\tfont-family:\\\\\\"Calibri\\\\\\",sans-serif;}\\\\r\\\\n/* Page Definitions */\\\\r\\\\n@page WordSection1\\\\r\\\\n\\\\t{size:612.0pt 792.0pt;\\\\r\\\\n\\\\tmargin:72.0pt 90.0pt 72.0pt 90.0pt;}\\\\r\\\\ndiv.WordSection1\\\\r\\\\n\\\\t{page:WordSection1;}\\\\r\\\\n--></style><!--[if gte mso 9]><xml>\\\\r\\\\n<o:shapedefaults v:ext=\\\\\\"edit\\\\\\" spidmax=\\\\\\"1026\\\\\\" />\\\\r\\\\n</xml><![endif]--><!--[if gte mso 9]><xml>\\\\r\\\\n<o:shapelayout v:ext=\\\\\\"edit\\\\\\">\\\\r\\\\n<o:idmap v:ext=\\\\\\"edit\\\\\\" data=\\\\\\"1\\\\\\" />\\\\r\\\\n</o:shapelayout></xml><![endif]-->\\\\r\\\\n</head>\\\\r\\\\n<body lang=\\\\\\"ZH-TW\\\\\\" link=\\\\\\"#0563C1\\\\\\" vlink=\\\\\\"#954F72\\\\\\" style=\\\\\\"word-wrap:break-word;text-justify-trim:punctuation\\\\\\">\\\\r\\\\n<div class=\\\\\\"WordSection1\\\\\\">\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\"><span lang=\\\\\\"EN-US\\\\\\"><o:p>&nbsp;</o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\"><span lang=\\\\\\"EN-US\\\\\\"><o:p>&nbsp;</o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">Best regards,</span><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:#222222\\\\\\"><o:p></o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">&nbsp;</span><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:#222222\\\\\\"><o:p></o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">Fan Hung (</span><span style=\\\\\\"font-family:SimSun;color:blue\\\\\\">洪振嘉<span lang=\\\\\\"EN-US\\\\\\">)<o:p></o:p></span></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">+886 2 27170886 #8580</span><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:#222222\\\\\\"><o:p></o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\"><span lang=\\\\\\"EN-US\\\\\\"><o:p>&nbsp;</o:p></span></p>\\\\r\\\\n</div>\\\\r\\\\n<p style=\\\\\\"font-weight: bold;color:black;font-size: 80%\\\\\\">因疫情影響，因應公證行以及貨櫃場成本調漲。本公司將於 2022 年 01 月 01 日起之結關船班，調漲台灣出口至美國、加拿大併櫃費用由目前之 NTD380/CBM or TON\\\\r\\\\n<span style=\\\\\\"background-color:yellow\\\\\\">變動為 NTD500/CBM or TON</span>。 感謝貴公司之愛護與支持，我們將秉持熱忱繼續為您服務</p>\\\\r\\\\n<hr>\\\\r\\\\n<p style=\\\\\\"font-weight: bold;color:darkblue;font-size: 80%\\\\\\">為應因COVID-19疫情急速升&#28201;情況下，我司針對提單發放擬建議採取下列相關原則及程序：</p>\\\\r\\\\n<ol style=\\\\\\"font-weight: bold;color:darkblue;font-size: 80%\\\\\\">\\\\r\\\\n<li>請儘量以電放提單來操作避免不必要之接觸，如有一定要領取正本提單時，請先與您的負責業務聯繫，也請需要有電放的準備.以防疫情再次升級，文件人員無法至公司列印正本提單時，可以電放方式放貨</li><li>繳費部份，將完全採取匯款方式，並於匯款完成時，以email方式(fdesk.tpe@oecgroup.com)通知我司會計以利正確入帳及順利放貨</li></ol>\\\\r\\\\n<p></p>\\\\r\\\\n<hr>\\\\r\\\\n<p style=\\\\\\"font-weight: bold;color:firebrick;font-size: 80%\\\\\\">詐騙案件提醒：近來財務詐騙案件猖獗，原則上OEC集團不會單獨透過email要求您更改付款的銀行與帳號，如果您有收到此類郵件，請與負責您業務的銷售人員、客戶服務人員，或財務連繫窗口確認核實郵件內容。客戶至上一直是我們的使命，您的業務與交易安全的確保，也是我們重視的一環，所有銀行帳戶更改通知請務必協助與我們做確認，謝謝您！</p>\\\\r\\\\n<hr>\\\\r\\\\n<p style=\\\\\\"font-weight:bold;color:firebrick;font-size: 80%\\\\\\">Fraud scam reminder：This is a reminder that OEC does not communicate changes to bank details or payment methods through Email. If you ever receive an Email that makes this request, please call your\\\\r\\\\n existing sales or customer service representative to verify any changes. OEC Group values your business and wants to ensure a safe transaction.</p>\\\\r\\\\n</body>\\\\r\\\\n</html>\\\\r\\\\n\\",\\"receivedDate\\":1665652116000,\\"sentDate\\":1665652115000,\\"contentType\\":\\"multipart/mixed; \\\\r\\\\n\\\\tboundary*0=_002_SEYPR03MB676994FC229E8C0E7B0824A493259SEYPR03MB6769apcp; \\\\r\\\\n\\\\tboundary*1=_\\",\\"attachments\\":[{\\"fileName\\":\\"04958597-A.pdf\\",\\"content\\":null,\\"contentType\\":\\"application/pdf; name=04958597-A.pdf\\",\\"S3PathKeyName\\":\\"attachments/2022-10-13/09-08-52.463.390982fd-92e6-4346-b1e1-3b73f6303453.pdf\\"}],\\"messageid\\":\\"<SEYPR03MB676994FC229E8C0E7B0824A493259@SEYPR03MB6769.apcprd03.prod.outlook.com>\\"}",
                                    "receivedDate": 1665652116000,
                                    "timestamp": 1665652132809
                                },
                                "sort": [
                                    1665652132809
                                ]
                            },
                            {
                                "_index": "b2b_email_20220520095414241",
                                "_type": "_doc",
                                "_id": "8d056aae-76a7-4439-9a2b-f5474a135987",
                                "_score": null,
                                "_source": {
                                    "cc": [],
                                    "ignored": false,
                                    "bcc": [],
                                    "attachments": [
                                        {
                                            "fileName": "04958597-A.pdf",
                                            "S3PathKeyName": "attachments/2022-10-13/09-07-16.449.99646c85-4b8b-4472-ae91-26c9a08d86e5.pdf",
                                            "contentType": "application/pdf; name=04958597-A.pdf"
                                        }
                                    ],
                                    "is_valid_subject": true,
                                    "offset": "34",
                                    "subject": "Invoice [04958597-A] PWTKCK219493",
                                    "messageid": "<SEYPR03MB6769478CC53EED6B876D7DCE93259@SEYPR03MB6769.apcprd03.prod.outlook.com>",
                                    "doc_type": "INVOICE_NO",
                                    "INVOICE_NO": "04958597-A",
                                    "HBL_NO": "PWTKCK219493",
                                    "sent": true,
                                    "sentDate": 1665652030000,
                                    "partner": "GRAINGER",
                                    "sender": "",
                                    "updated_timestamp": "2022-10-13T17:07:20+08:00",
                                    "replyTo": [
                                        "fan.mis@oecgroup.com"
                                    ],
                                    "from": "fan.mis@oecgroup.com",
                                    "id": "8d056aae-76a7-4439-9a2b-f5474a135987",
                                    "to": [
                                        "b2b-invoice.test@oecgroup.com"
                                    ],
                                    "value": "{\\"from\\":[\\"fan.mis@oecgroup.com\\"],\\"replyTo\\":[\\"fan.mis@oecgroup.com\\"],\\"to\\":[\\"b2b-invoice.test@oecgroup.com\\"],\\"cc\\":[],\\"bcc\\":[],\\"sender\\":\\"\\",\\"subject\\":\\"Invoice [04958597-A] PWTKCK219493\\",\\"textBody\\":null,\\"htmlBody\\":\\"<html xmlns:v=\\\\\\"urn:schemas-microsoft-com:vml\\\\\\" xmlns:o=\\\\\\"urn:schemas-microsoft-com:office:office\\\\\\" xmlns:w=\\\\\\"urn:schemas-microsoft-com:office:word\\\\\\" xmlns:m=\\\\\\"http://schemas.microsoft.com/office/2004/12/omml\\\\\\" xmlns=\\\\\\"http://www.w3.org/TR/REC-html40\\\\\\">\\\\r\\\\n<head>\\\\r\\\\n<meta http-equiv=\\\\\\"Content-Type\\\\\\" content=\\\\\\"text/html; charset=big5\\\\\\">\\\\r\\\\n<meta name=\\\\\\"Generator\\\\\\" content=\\\\\\"Microsoft Word 15 (filtered medium)\\\\\\">\\\\r\\\\n<style><!--\\\\r\\\\n/* Font Definitions */\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:SimSun;\\\\r\\\\n\\\\tpanose-1:2 1 6 0 3 1 1 1 1 1;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:新細明體;\\\\r\\\\n\\\\tpanose-1:2 2 5 0 0 0 0 0 0 0;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:\\\\\\"Cambria Math\\\\\\";\\\\r\\\\n\\\\tpanose-1:2 4 5 3 5 4 6 3 2 4;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:Calibri;\\\\r\\\\n\\\\tpanose-1:2 15 5 2 2 2 4 3 2 4;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:\\\\\\"\\\\\\\\@SimSun\\\\\\";\\\\r\\\\n\\\\tpanose-1:2 1 6 0 3 1 1 1 1 1;}\\\\r\\\\n@font-face\\\\r\\\\n\\\\t{font-family:\\\\\\"\\\\\\\\@新細明體\\\\\\";\\\\r\\\\n\\\\tpanose-1:2 1 6 1 0 1 1 1 1 1;}\\\\r\\\\n/* Style Definitions */\\\\r\\\\np.MsoNormal, li.MsoNormal, div.MsoNormal\\\\r\\\\n\\\\t{margin:0cm;\\\\r\\\\n\\\\tfont-size:12.0pt;\\\\r\\\\n\\\\tfont-family:\\\\\\"Calibri\\\\\\",sans-serif;}\\\\r\\\\nspan.EmailStyle17\\\\r\\\\n\\\\t{mso-style-type:personal-compose;\\\\r\\\\n\\\\tfont-family:\\\\\\"Calibri\\\\\\",sans-serif;\\\\r\\\\n\\\\tcolor:windowtext;\\\\r\\\\n\\\\tfont-weight:normal;\\\\r\\\\n\\\\tfont-style:normal;}\\\\r\\\\n.MsoChpDefault\\\\r\\\\n\\\\t{mso-style-type:export-only;\\\\r\\\\n\\\\tfont-family:\\\\\\"Calibri\\\\\\",sans-serif;}\\\\r\\\\n/* Page Definitions */\\\\r\\\\n@page WordSection1\\\\r\\\\n\\\\t{size:612.0pt 792.0pt;\\\\r\\\\n\\\\tmargin:72.0pt 90.0pt 72.0pt 90.0pt;}\\\\r\\\\ndiv.WordSection1\\\\r\\\\n\\\\t{page:WordSection1;}\\\\r\\\\n--></style><!--[if gte mso 9]><xml>\\\\r\\\\n<o:shapedefaults v:ext=\\\\\\"edit\\\\\\" spidmax=\\\\\\"1026\\\\\\" />\\\\r\\\\n</xml><![endif]--><!--[if gte mso 9]><xml>\\\\r\\\\n<o:shapelayout v:ext=\\\\\\"edit\\\\\\">\\\\r\\\\n<o:idmap v:ext=\\\\\\"edit\\\\\\" data=\\\\\\"1\\\\\\" />\\\\r\\\\n</o:shapelayout></xml><![endif]-->\\\\r\\\\n</head>\\\\r\\\\n<body lang=\\\\\\"ZH-TW\\\\\\" link=\\\\\\"#0563C1\\\\\\" vlink=\\\\\\"#954F72\\\\\\" style=\\\\\\"word-wrap:break-word;text-justify-trim:punctuation\\\\\\">\\\\r\\\\n<div class=\\\\\\"WordSection1\\\\\\">\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\"><span lang=\\\\\\"EN-US\\\\\\"><o:p>&nbsp;</o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\"><span lang=\\\\\\"EN-US\\\\\\"><o:p>&nbsp;</o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">Best regards,</span><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:#222222\\\\\\"><o:p></o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">&nbsp;</span><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:#222222\\\\\\"><o:p></o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">Fan Hung (</span><span style=\\\\\\"font-family:SimSun;color:blue\\\\\\">洪振嘉<span lang=\\\\\\"EN-US\\\\\\">)<o:p></o:p></span></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\" style=\\\\\\"background:white\\\\\\"><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:blue\\\\\\">+886 2 27170886 #8580</span><span lang=\\\\\\"EN-US\\\\\\" style=\\\\\\"font-family:SimSun;color:#222222\\\\\\"><o:p></o:p></span></p>\\\\r\\\\n<p class=\\\\\\"MsoNormal\\\\\\"><span lang=\\\\\\"EN-US\\\\\\"><o:p>&nbsp;</o:p></span></p>\\\\r\\\\n</div>\\\\r\\\\n<p style=\\\\\\"font-weight: bold;color:black;font-size: 80%\\\\\\">因疫情影響，因應公證行以及貨櫃場成本調漲。本公司將於 2022 年 01 月 01 日起之結關船班，調漲台灣出口至美國、加拿大併櫃費用由目前之 NTD380/CBM or TON\\\\r\\\\n<span style=\\\\\\"background-color:yellow\\\\\\">變動為 NTD500/CBM or TON</span>。 感謝貴公司之愛護與支持，我們將秉持熱忱繼續為您服務</p>\\\\r\\\\n<hr>\\\\r\\\\n<p style=\\\\\\"font-weight: bold;color:darkblue;font-size: 80%\\\\\\">為應因COVID-19疫情急速升&#28201;情況下，我司針對提單發放擬建議採取下列相關原則及程序：</p>\\\\r\\\\n<ol style=\\\\\\"font-weight: bold;color:darkblue;font-size: 80%\\\\\\">\\\\r\\\\n<li>請儘量以電放提單來操作避免不必要之接觸，如有一定要領取正本提單時，請先與您的負責業務聯繫，也請需要有電放的準備.以防疫情再次升級，文件人員無法至公司列印正本提單時，可以電放方式放貨</li><li>繳費部份，將完全採取匯款方式，並於匯款完成時，以email方式(fdesk.tpe@oecgroup.com)通知我司會計以利正確入帳及順利放貨</li></ol>\\\\r\\\\n<p></p>\\\\r\\\\n<hr>\\\\r\\\\n<p style=\\\\\\"font-weight: bold;color:firebrick;font-size: 80%\\\\\\">詐騙案件提醒：近來財務詐騙案件猖獗，原則上OEC集團不會單獨透過email要求您更改付款的銀行與帳號，如果您有收到此類郵件，請與負責您業務的銷售人員、客戶服務人員，或財務連繫窗口確認核實郵件內容。客戶至上一直是我們的使命，您的業務與交易安全的確保，也是我們重視的一環，所有銀行帳戶更改通知請務必協助與我們做確認，謝謝您！</p>\\\\r\\\\n<hr>\\\\r\\\\n<p style=\\\\\\"font-weight:bold;color:firebrick;font-size: 80%\\\\\\">Fraud scam reminder：This is a reminder that OEC does not communicate changes to bank details or payment methods through Email. If you ever receive an Email that makes this request, please call your\\\\r\\\\n existing sales or customer service representative to verify any changes. OEC Group values your business and wants to ensure a safe transaction.</p>\\\\r\\\\n</body>\\\\r\\\\n</html>\\\\r\\\\n\\",\\"receivedDate\\":1665652032000,\\"sentDate\\":1665652030000,\\"contentType\\":\\"multipart/mixed; \\\\r\\\\n\\\\tboundary*0=_002_SEYPR03MB6769478CC53EED6B876D7DCE93259SEYPR03MB6769apcp; \\\\r\\\\n\\\\tboundary*1=_\\",\\"attachments\\":[{\\"fileName\\":\\"04958597-A.pdf\\",\\"content\\":null,\\"contentType\\":\\"application/pdf; name=04958597-A.pdf\\",\\"S3PathKeyName\\":\\"attachments/2022-10-13/09-07-16.449.99646c85-4b8b-4472-ae91-26c9a08d86e5.pdf\\"}],\\"messageid\\":\\"<SEYPR03MB6769478CC53EED6B876D7DCE93259@SEYPR03MB6769.apcprd03.prod.outlook.com>\\"}",
                                    "receivedDate": 1665652032000,
                                    "timestamp": 1665652036867
                                },
                                "sort": [
                                    1665652036867
                                ]
                            }
                          \s
                        ]
                    }
                }
                """;
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    @PostMapping(path = "/trigger/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "trigger task",
            description = "手動觸發任務")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "success") })

    public ResponseEntity<Object> trigger(
        @Parameter(description = "id", example = "1111") @PathVariable String id,
        @Parameter(description = "request body")
        TriggerRequest data
    ) {
        var entities = new Object();
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }
}
