import pytz
import datetime
import cloudscraper
import time

tz = pytz.timezone('Europe/Berlin')

if __name__ == "__main__":
    loop = True
    lastcheck = 0
    while loop == True:
        now = datetime.datetime.now(tz)
        dateday = now.strftime('%Y-%m-%d')
        hour = now.hour
        minutes = now.minute
        day = now.strftime('%d')
        if hour >= 10 and lastcheck != day:
            cron_init = cloudscraper.create_scraper()
            cron_init.get("CRON_URL", headers={'Cache-Control': 'no-cache'})
            lastcheck = day
            print(lastcheck)
        time.sleep(20)