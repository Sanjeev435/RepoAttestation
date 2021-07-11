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

function formatDate(dateTemp) {
		const date = new Date(dateTemp);

		var hours = date.getHours();
		var minutes = date.getMinutes();
		var ampm = hours >= 12 ? 'PM' : 'AM';
		hours = hours % 12;
		hours = hours ? hours : 12; // the hour '0' should be '12'
		minutes = minutes < 10 ? '0' + minutes : minutes;
		var strTime = (hours < 10 ? '0' + hours : hours)   + ':' + minutes + ' ' + ampm;
		return daysInWeek[date.getDay()] 
		       + " , " 
		       + (date.getDate() < 10 ? '0' + date.getDate() : date.getDate())
		       + " " 
		       + monthsInYear[date.getMonth()] 
		       + " " + date.getFullYear() 
		       + "  " 
		       + strTime;
	}