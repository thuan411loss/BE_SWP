import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  vus: 10,
  duration: '30s',
};
export default function () {
    let res = http.get('https://www.dienmayxanh.com/may-lanh?utm_source=A8WKOm1Ng&click_id=zKEfFlztH2ABuyJLMJG2KUzQX4HD8_DIuFExQdl4LIM&gad_source=1&gad_campaignid=22253923118&gbraid=0AAAAA-dRZ4rG8M-8sdhPtqWrheb8qGZvJ&gclid=Cj0KCQjwmK_CBhCEARIsAMKwcD7vCGrjTM_pgnqSBuvRti_q3WZ7tIr3VWEch4eDNfFz-jzf8vfnc3MaApzWEALw_wcB');
    check(res, {
        'status is 200': (r) => r.status === 200,
    });
    sleep(1);
}