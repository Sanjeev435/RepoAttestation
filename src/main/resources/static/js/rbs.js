var contextUrl = 'http://localhost:8080/rbs/attestation';
const daysInWeek = [
  'Sun',
  'Mon',
  'Tue',
  'Wed',
  'Thu',
  'Fri',
  'Sat'
];

const monthsInYear = [
  'Jan',
  'Feb',
  'Mar',
  'Apr',
  'May',
  'Jun',
  'Jul',
  'Aug',
  'Sep',
  'Oct',
  'Nov',
  'Dec'
];

function clearAdminLogin() {
  localStorage['attestationLoginName'] = '';
}

function pageRedirect(relativePath) {
 window.location.replace(contextUrl + relativePath);
} 